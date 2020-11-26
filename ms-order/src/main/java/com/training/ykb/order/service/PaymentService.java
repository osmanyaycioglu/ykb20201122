package com.training.ykb.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.training.ykb.order.accounting.client.IAccountingClient;
import com.training.ykb.order.model.Order;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate      rt;

    @Value("${server.port}")
    private int               port;

    @Autowired
    private EurekaClient      ec;

    @Autowired
    private IAccountingClient iac;

    public String placeOrderFeign(final Order orderParam) throws Exception {
        return "Request from : " + this.port + " : " + this.iac.pay(orderParam);
    }

    public String placeOrder(final Order orderParam) {
        String postForObjectLoc = this.rt.postForObject("http://ACCOUNTING/accounting/pay",
                                                        orderParam,
                                                        String.class);
        return "Request from : " + this.port + " : " + postForObjectLoc;
    }

    public String placeOrderEureka(final Order orderParam) {
        RestTemplate restT = new RestTemplate();
        List<InstanceInfo> instancesLoc = this.ec.getApplication("ACCOUNTING")
                                                 .getInstances();
        for (InstanceInfo instanceInfoLoc : instancesLoc) {
            System.out.println(instanceInfoLoc);
        }

        InstanceInfo nse = this.ec.getNextServerFromEureka("ACCOUNTING",
                                                           false);


        String postForObjectLoc = restT.postForObject("http://"
                                                      + nse.getIPAddr()
                                                      + ":"
                                                      + nse.getPort()
                                                      + "/accounting/pay",
                                                      orderParam,
                                                      String.class);
        return "Request from : " + this.port + " : " + postForObjectLoc;
    }

}

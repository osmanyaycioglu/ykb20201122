package com.training.ykb.order.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationResponseListener {


    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "notf_res_q",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "noft_direct_res_exc",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "notf_res"))
    public void handleEventResponse(final String no) {
        System.out.println("handled message : " + no);
    }

}

package com.training.ykb.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.order.model.Order;
import com.training.ykb.order.service.PaymentService;

@RestController
@RequestMapping("/order")
public class OrderRest {

    @Autowired
    private PaymentService ps;

    @PostMapping("/place")
    public String placeOrder(@RequestBody final Order order) {
        return this.ps.placeOrder(order);
    }

    @PostMapping("/place2")
    public String placeOrder2(@RequestBody final Order order) throws Exception {
        return this.ps.placeOrderFeign(order);
    }

}

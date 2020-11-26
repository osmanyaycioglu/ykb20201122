package com.training.ykb.accounting.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.order.model.Order;

@RestController
@RequestMapping("/accounting")
public class AccountingRest {

    @Value("${server.port}")
    private int port;

    @PostMapping("/pay")
    public String pay(@RequestBody final Order orderParam) {
        return "OK-" + this.port;
    }

}

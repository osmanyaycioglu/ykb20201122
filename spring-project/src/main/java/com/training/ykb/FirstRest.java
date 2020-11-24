package com.training.ykb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class FirstRest {

    @Autowired
    private MySpringBean msb;

    @GetMapping
    public String hello() {
        return this.msb.yap();
    }

}

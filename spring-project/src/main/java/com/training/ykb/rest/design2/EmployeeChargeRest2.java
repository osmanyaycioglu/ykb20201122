package com.training.ykb.rest.design2;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.model.Employee;

@RestController
@RequestMapping("/api/v1/employee/charge")
public class EmployeeChargeRest2 {

    @PostMapping
    public String charge(@RequestBody final Employee emp) {
        return "OK";
    }


}

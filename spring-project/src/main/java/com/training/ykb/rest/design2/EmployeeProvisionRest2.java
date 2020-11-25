package com.training.ykb.rest.design2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.model.Employee;

@RestController
@RequestMapping("/api/v1/employee/provision")
public class EmployeeProvisionRest2 {

    @PostMapping("/add")
    public String add(@RequestBody final Employee emp) {
        return "OK";
    }

    @PostMapping("/delete")
    public String deactivate(@RequestBody final Employee emp) {
        return "OK";
    }

    @PostMapping("/update")
    public String update(@RequestBody final Employee emp) {
        return "OK";
    }

    @GetMapping("/get")
    public Employee get(@RequestParam("id") final long id) {
        return null;
    }

}

package com.training.ykb.rest.design1;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.model.Employee;

@RestController
@RequestMapping("/api/v1/employee/provision")
public class EmployeeProvisionRest {

    @PutMapping
    public String add(@RequestBody final Employee emp) {
        return "OK";
    }

    @DeleteMapping
    public String deactivate(@RequestBody final Employee emp) {
        return "OK";
    }

    @PatchMapping
    public String update(@RequestBody final Employee emp) {
        return "OK";
    }

    @GetMapping
    public Employee get(@RequestParam("id") final long id) {
        return null;
    }


}

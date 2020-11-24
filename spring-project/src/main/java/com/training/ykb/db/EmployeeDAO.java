package com.training.ykb.db;

import org.springframework.stereotype.Component;

import com.training.ykb.model.Employee;

@Component
public class EmployeeDAO {

    public String writeEmpleyee(final Employee emp) {
        return "OK";
    }

}

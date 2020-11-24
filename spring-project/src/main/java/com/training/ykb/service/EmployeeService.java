package com.training.ykb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.ykb.db.EmployeeDAO;
import com.training.ykb.model.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO empDAO;

    public String addEmpleyee(final Employee emp) {
        return this.empDAO.writeEmpleyee(emp);
    }


}

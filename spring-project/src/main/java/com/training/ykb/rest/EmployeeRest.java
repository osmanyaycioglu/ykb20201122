package com.training.ykb.rest;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.model.Employee;
import com.training.ykb.rest.error.ErrorObj;
import com.training.ykb.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@Validated
public class EmployeeRest {

    @Autowired
    private EmployeeService es;

    @GetMapping("/addnew/{abc}/{xyz}")
    public String addnew(@PathVariable("abc") final String name,
                         @PathVariable("xyz") final String surname) {
        return "Adding New : " + name + " " + surname;
    }

    @GetMapping("/addnew2")
    public String addnew2(@NotNull @RequestParam("isim") final String name,
                          @NotNull @RequestParam("soyisim") final String surname) {
        return "Adding New 2 : " + name + " " + surname;
    }

    @GetMapping("/addnew3/{isim}")
    public String addnew3(@PathVariable("isim") final String name,
                          @RequestParam("soyisim") final String surname) {
        return "Adding New 3 : " + name + " " + surname;
    }

    @GetMapping("/addnew4")
    public String addnew4(@RequestHeader("isim") final String name,
                          @RequestHeader("soyisim") final String surname) {
        return "Adding New 4 : " + name + " " + surname;
    }

    @PostMapping("/addnew5")
    public String addnew5(@Validated @RequestBody final Employee emp) {
        if (emp.getAge() != null) {
            if ((emp.getAge() > 120) || (emp.getAge() < 18)) {
                throw new IllegalArgumentException("age 18 ile 120 arasında");
            }
        }
        this.es.addEmpleyee(emp);
        return "Adding New 5 : " + emp;
    }


    @GetMapping("/test")
    public String get() {
        return "Hello Get";
    }

    @PostMapping("/test")
    public String post() {
        return "Hello Post";
    }

    @PutMapping("/test")
    public String put() {
        return "Hello Put";
    }

    @DeleteMapping("/test")
    public String delete() {
        return "Hello Delete";
    }

    @PatchMapping("/test")
    public String patch() {
        return "Hello Patch";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final IllegalArgumentException exp) {
        return new ErrorObj().setDomain("IT")
                             .setSubDomain("CRM")
                             .setBoundedContext("kampanyalar")
                             .setMicroservice("ackapa")
                             .setErrorDesc(exp.getMessage())
                             .setCause(101);
    }

}

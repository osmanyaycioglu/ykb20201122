package com.training.ykb.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.training.ykb.validation.StartWithCheck;

@XmlRootElement
public class Employee {

    @NotEmpty
    @Size(min = 2, max = 30, message = "Employee name 2 ile 30 arasında olmalı")
    @StartWithCheck(start = "test", message = "name test ile başlamalı")
    private String  name;
    @StartWithCheck(start = "test", message = "surname test ile başlamalı")
    private String  surname;
    @Max(120)
    @Min(18)
    private Integer age;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(final Integer ageParam) {
        this.age = ageParam;
    }

    @Override
    public String toString() {
        return "Employee [name=" + this.name + ", surname=" + this.surname + ", age=" + this.age + "]";
    }


}

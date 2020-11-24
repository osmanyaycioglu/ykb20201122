package com.training.ykb.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Employee {

    @NotEmpty
    @Size(min = 2, max = 30, message = "Employee name 2 ile 30 arasında olmalı")
    private String  name;
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

package com.training.ykb.order.model;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Order {

    @NotEmpty
    @Size(min = 5)
    private String       orderName;
    @Max(1000)
    private Integer      amount;
    @Size(max = 30)
    @NotNull
    private List<String> meals;

    public String getOrderName() {
        return this.orderName;
    }

    public void setOrderName(final String orderNameParam) {
        this.orderName = orderNameParam;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(final Integer amountParam) {
        this.amount = amountParam;
    }

    public List<String> getMeals() {
        return this.meals;
    }

    public void setMeals(final List<String> mealsParam) {
        this.meals = mealsParam;
    }


}

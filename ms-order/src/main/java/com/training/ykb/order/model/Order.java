package com.training.ykb.order.model;

import java.util.List;


public class Order {

    private String       orderName;
    private Integer      amount;
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

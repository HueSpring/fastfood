package com.food.form;

import javax.validation.constraints.NotNull;

/**
 * Created by Hue on 11/15/2016.
 */
public class OrderForm {

    @NotNull
    private String customerId;
    @NotNull
    private int orderTypeId;
    private String address;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(int orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

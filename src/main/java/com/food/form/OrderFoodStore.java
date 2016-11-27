package com.food.form;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;

/**
 * Created by Hue on 11/15/2016.
 */
public class OrderFoodStore {

    @NotNull
    @NumberFormat
    private int quantity;
    @NotNull
    private int orderId;
    @NotNull
    private int foodOrderId;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getFoodOrderId() {
        return foodOrderId;
    }

    public void setFoodOrderId(int foodOrderId) {
        this.foodOrderId = foodOrderId;
    }
}

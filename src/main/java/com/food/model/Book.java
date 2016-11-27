package com.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hue on 11/16/2016.
 */
@Entity
@Table(name = "book")
public class Book {

    @Id
    private String id;
    private String address;
    private int status;
    private String dateOrder;
    private String dateBill;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "order_type_id")
    private OrderType orderType;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "book")
    @JsonIgnore
    private Set<OrderFoodStore> orderFoodStores;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Book() {
    }

    public Book(String id, String address, int status, String dateOrder, String dateBill, OrderType orderType, User user, Set<OrderFoodStore> orderFoodStores, Customer customer) {
        this.id = id;
        this.address = address;
        this.status = status;
        this.dateOrder = dateOrder;
        this.dateBill = dateBill;
        this.orderType = orderType;
        this.user = user;
        this.orderFoodStores = orderFoodStores;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Book(String id, String address, int status, String dateOrder, String dateBill, User user) {
        this.id = id;
        this.address = address;
        this.status = status;
        this.dateOrder = dateOrder;
        this.dateBill = dateBill;
        this.user = user;
    }

    public Book(String id, String address, int status, String dateOrder, OrderType orderType) {
        this.id = id;
        this.address = address;
        this.status = status;
        this.dateOrder = dateOrder;
        this.orderType = orderType;
    }

    public Book(String id, String address, int status, String dateOrder, String dateBill, OrderType orderType, User user, Set<OrderFoodStore> orderFoodStores) {
        this.id = id;
        this.address = address;
        this.status = status;
        this.dateOrder = dateOrder;
        this.dateBill = dateBill;
        this.orderType = orderType;
        this.user = user;
        this.orderFoodStores = orderFoodStores;
    }

    public int getStatus() {
        return status;
    }

    public Set<OrderFoodStore> getOrderFoodStores() {
        return orderFoodStores;
    }

    public void setOrderFoodStores(Set<OrderFoodStore> orderFoodStores) {
        this.orderFoodStores = orderFoodStores;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getDateBill() {
        return dateBill;
    }

    public void setDateBill(String dateBill) {
        this.dateBill = dateBill;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

}

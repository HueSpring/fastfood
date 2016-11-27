package com.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hue on 11/12/2016.
 */
@Entity
@Table(name = "food_store")
public class FoodStore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int status;
    private int statusPromotion;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Book book;

    @OneToMany(mappedBy = "foodStore")
    private Set<OrderFoodStore> orderFoodStores;

    public FoodStore() {
    }

    public FoodStore(Store store, Food food) {
        this.store = store;
        this.food = food;
    }

    public FoodStore(int status, int statusPromotion, Store store) {
        this.status = status;
        this.statusPromotion = statusPromotion;
        this.store = store;
    }

    public FoodStore(int status, int statusPromotion) {
        this.status = status;
        this.statusPromotion = statusPromotion;
    }

    public FoodStore(int status, int statusPromotion, Store store, Food food, Book book, Set<OrderFoodStore> orderFoodStores) {
        this.status = status;
        this.statusPromotion = statusPromotion;
        this.store = store;
        this.food = food;
        this.book = book;
        this.orderFoodStores = orderFoodStores;
    }

    public FoodStore(int status, int statusPromotion, Store store, Food food) {
        this.status = status;
        this.statusPromotion = statusPromotion;
        this.store = store;
        this.food = food;
    }

    public Set<OrderFoodStore> getOrderFoodStores() {
        return orderFoodStores;
    }

    public void setOrderFoodStores(Set<OrderFoodStore> orderFoodStores) {
        this.orderFoodStores = orderFoodStores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatusPromotion() {
        return statusPromotion;
    }

    public void setStatusPromotion(int statusPromotion) {
        this.statusPromotion = statusPromotion;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Book getOrder() {
        return book;
    }

    public void setOrder(Book book) {
        this.book = book;
    }
}

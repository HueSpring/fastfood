package com.food.model;

import org.aspectj.weaver.ast.Or;

import javax.persistence.*;

/**
 * Created by Hue on 11/15/2016.
 */
@Entity
@Table(name = "order_food_store")
public class OrderFoodStore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "food_store_id")
    private FoodStore foodStore;


    public OrderFoodStore() {
    }

    public OrderFoodStore(int quantity, Book book, FoodStore foodStore) {
        this.quantity = quantity;
        this.book = book;
        this.foodStore = foodStore;
    }


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public OrderFoodStore(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Book getOrder() {
        return book;
    }

    public void setOrder(Book book) {
        this.book = book;
    }

    public FoodStore getFoodStore() {
        return foodStore;
    }

    public void setFoodStore(FoodStore foodStore) {
        this.foodStore = foodStore;
    }
}

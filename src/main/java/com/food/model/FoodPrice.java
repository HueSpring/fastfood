package com.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Hue on 11/16/2016.
 */
@Entity
@Table(name = "food_price")
public class FoodPrice {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int price;
    private String dateBegin;
    private String dateEnd;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "food_id")
    private Food food;

    public FoodPrice() {
    }

    public FoodPrice(int price, String dateBegin, String dateEnd) {
        this.price = price;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }

    public FoodPrice(int price, String dateBegin, String dateEnd, Food food) {
        this.price = price;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.food = food;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}

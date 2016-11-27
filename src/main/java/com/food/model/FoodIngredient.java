package com.food.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hue on 11/12/2016.
 */
@Entity
@Table(name = "food_ingredient")
public class FoodIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int quantity;
    private String unit;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;
    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    public FoodIngredient() {
    }

    public FoodIngredient(int quantity, String unit) {
        this.quantity = quantity;
        this.unit = unit;
    }

    public FoodIngredient(int quantity, String unit, Ingredient ingredient) {
        this.quantity = quantity;
        this.unit = unit;
        this.ingredient = ingredient;
    }

    public FoodIngredient(int quantity, String unit, Food food) {
        this.quantity = quantity;
        this.unit = unit;
        this.food = food;
    }

    public FoodIngredient(int quantity, String unit, Ingredient ingredient, Food food) {
        this.quantity = quantity;
        this.unit = unit;
        this.ingredient = ingredient;
        this.food = food;
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

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}


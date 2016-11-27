package com.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hue on 11/12/2016.
 */
@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int price;
    private String image;

    @OneToMany(mappedBy = "food")
    @JsonIgnore
    private Set<FoodStore> foodStores;

    @OneToMany(mappedBy = "food")
    @JsonIgnore
    private Set<FoodIngredient> foodIngredients;


    @OneToMany(mappedBy = "food")
    private Set<FoodPrice> foodPrices;

    @ManyToOne
    @JoinColumn(name = "food_type_id")
    private FoodType foodType;

    public Food() {
    }

    public Food(String name, int price, String image, FoodType foodType) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.foodType = foodType;
    }

    public Food(String name, int price, String image, Set<FoodStore> foodStores, Set<FoodIngredient> foodIngredients, Set<FoodPrice> foodPrices, FoodType foodType) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.foodStores = foodStores;
        this.foodIngredients = foodIngredients;
        this.foodPrices = foodPrices;
        this.foodType = foodType;
    }

    public Food(String name, int price, String image, Set<FoodIngredient> foodIngredients) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.foodIngredients = foodIngredients;
    }

    public Food(String name, int price, String image, Set<FoodStore> foodStores, Set<FoodIngredient> foodIngredients, Set<FoodPrice> foodPrices) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.foodStores = foodStores;
        this.foodIngredients = foodIngredients;
        this.foodPrices = foodPrices;
    }

    public Food(String name, int price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public Food(String name, int price, String image, Set<FoodStore> foodStores, Set<FoodIngredient> foodIngredients) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.foodStores = foodStores;
        this.foodIngredients = foodIngredients;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public Set<FoodPrice> getFoodPrices() {
        return foodPrices;
    }

    public void setFoodPrices(Set<FoodPrice> foodPrices) {
        this.foodPrices = foodPrices;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<FoodStore> getFoodStores() {
        return foodStores;
    }

    public void setFoodStores(Set<FoodStore> foodStores) {
        this.foodStores = foodStores;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<FoodIngredient> getFoodIngredients() {
        return foodIngredients;
    }

    public void setFoodIngredients(Set<FoodIngredient> foodIngredients) {
        this.foodIngredients = foodIngredients;
    }
}

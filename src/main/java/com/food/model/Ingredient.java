package com.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hue on 11/4/2016.
 */
@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String image;
    private String unit;

    @OneToMany(mappedBy = "ingredient")
    @JsonIgnore
    private Set<FoodIngredient> foodIngredients;

    @OneToMany(mappedBy = "ingredient")
    @JsonIgnore
    private Set<ImportIngredient> importIngredients;


    @OneToMany(mappedBy = "ingredient")
    @JsonIgnore
    private Set<StoreIngredient> storeIngredients;

    public Ingredient() {
    }

    public Ingredient(String name, String image, String unit) {
        this.name = name;
        this.image = image;
        this.unit = unit;
    }

    public Ingredient(String name, String image, String unit,Set<FoodIngredient> foodIngredients) {
        this.name = name;
        this.image = image;
        this.unit = unit;
        this.foodIngredients = foodIngredients;
    }

    public Ingredient(String name, String image, String unit, Set<FoodIngredient> foodIngredients, Set<ImportIngredient> importIngredients, Set<StoreIngredient> storeIngredients) {
        this.name = name;
        this.image = image;
        this.unit = unit;
        this.foodIngredients = foodIngredients;
        this.importIngredients = importIngredients;
        this.storeIngredients = storeIngredients;
    }

    public Set<StoreIngredient> getStoreIngredients() {
        return storeIngredients;
    }

    public void setStoreIngredients(Set<StoreIngredient> storeIngredients) {
        this.storeIngredients = storeIngredients;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Set<ImportIngredient> getImportIngredients() {
        return importIngredients;
    }

    public void setImportIngredients(Set<ImportIngredient> importIngredients) {
        this.importIngredients = importIngredients;
    }
}

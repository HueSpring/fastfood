package com.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hue on 11/16/2016.
 */
@Entity
@Table(name = "food_type")
public class FoodType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(mappedBy = "foodType")
    @JsonIgnore
    private Set<Food> foods;

    public FoodType() {
    }

    public FoodType(String name) {
        this.name = name;
    }

    public FoodType(String name, Set<Food> foods) {
        this.name = name;
        this.foods = foods;
    }

    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
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
}

package com.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hue on 10/31/2016.
 */
@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String noStreet;
    private String district;
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<User> users;

    @OneToMany(mappedBy = "store")
    @JsonIgnore
    private Set<StoreIngredient> storeIngredients;

    @OneToMany(mappedBy = "store")
    @JsonIgnore
    private Set<FoodStore> foodStores;

    public Store() {
    }

    public Store(String name, String noStreet, String district) {
        this.name = name;
        this.noStreet = noStreet;
        this.district = district;
    }

    public Store(String name, String noStreet, String district, Set<User> users) {
        this.name = name;
        this.noStreet = noStreet;
        this.district = district;
        this.users = users;
    }

    public Store(String name, String noStreet, String district, Set<User> users, Set<StoreIngredient> storeIngredients) {
        this.name = name;
        this.noStreet = noStreet;
        this.district = district;
        this.users = users;
        this.storeIngredients = storeIngredients;
    }

    public Store(String name, String noStreet, String district, Set<User> users, Set<StoreIngredient> storeIngredients, Set<FoodStore> foodStores) {
        this.name = name;
        this.noStreet = noStreet;
        this.district = district;
        this.users = users;
        this.storeIngredients = storeIngredients;
        this.foodStores = foodStores;
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

    public String getNoStreet() {
        return noStreet;
    }

    public void setNoStreet(String noStreet) {
        this.noStreet = noStreet;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<StoreIngredient> getStoreIngredients() {
        return storeIngredients;
    }

    public void setStoreIngredients(Set<StoreIngredient> storeIngredients) {
        this.storeIngredients = storeIngredients;
    }

    public Set<FoodStore> getFoodStores() {
        return foodStores;
    }

    public void setFoodStores(Set<FoodStore> foodStores) {
        this.foodStores = foodStores;
    }

}

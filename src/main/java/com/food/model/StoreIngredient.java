package com.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hue on 11/3/2016.
 */
@Entity
@Table(name = "store_ingredient")
public class StoreIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "storeIngredient")
    private Set<ImportStoreIngredient> importStoreIngredients;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @OneToMany(mappedBy = "storeIngredient")
    @JsonIgnore
    private Set<RequireIngredient> requireIngredients;

    public StoreIngredient() {
    }

    public StoreIngredient(Store store, Ingredient ingredient) {
        this.store = store;
        this.ingredient = ingredient;
    }

    public StoreIngredient(Store store, Set<ImportStoreIngredient> importStoreIngredients, Ingredient ingredient, Set<RequireIngredient> requireIngredients) {
        this.store = store;
        this.importStoreIngredients = importStoreIngredients;
        this.ingredient = ingredient;
        this.requireIngredients = requireIngredients;
    }

    public Set<RequireIngredient> getRequireIngredients() {
        return requireIngredients;
    }

    public void setRequireIngredients(Set<RequireIngredient> requireIngredients) {
        this.requireIngredients = requireIngredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Set<ImportStoreIngredient> getImportStoreIngredients() {
        return importStoreIngredients;
    }

    public void setImportStoreIngredients(Set<ImportStoreIngredient> importStoreIngredients) {
        this.importStoreIngredients = importStoreIngredients;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}

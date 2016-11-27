package com.food.form;

import javax.validation.constraints.NotNull;

/**
 * Created by Hue on 11/26/2016.
 */
public class StoreIngredientForm {

    @NotNull
    private int storeId;
    @NotNull
    private int ingredientId;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }
}

package com.food.service;

import com.food.common.Common;
import com.food.exception.ExceptionForm;
import com.food.model.ImportIngredient;
import com.food.model.Ingredient;
import com.food.model.Store;
import com.food.model.StoreIngredient;
import com.food.repository.ImportIngredientRepository;
import com.food.repository.IngredientRepository;
import com.food.repository.StoreIngredientRepository;
import com.food.repository.StoreReponsitory;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

/**
 * Created by Hue on 11/24/2016.
 */ @Service
public class StoreIngredientService {

    @Autowired
    private StoreIngredientRepository storeIngredientRepository;

    @Autowired
    private StoreReponsitory storeReponsitory;

    @Autowired
    private IngredientRepository ingredientRepository;

    public Iterable<StoreIngredient> findAll(){
        return storeIngredientRepository.findAll();
    }

    public StoreIngredient findOne(int storeId){
        if(!storeReponsitory.exists(storeId)){
            throw new ExceptionForm("Store", ExceptionForm.ERROR_CODE.EXIST, "Store is not exist");
        }
        return storeIngredientRepository.findOne(storeId);
    }

    public StoreIngredient save(int storeId, int ingredientId ){
        if(!storeReponsitory.exists(storeId)){
            throw new ExceptionForm("Store", ExceptionForm.ERROR_CODE.EXIST, "Store is not exist");
        }
        if(!ingredientRepository.exists(ingredientId)){
            throw new ExceptionForm("Ingredient", ExceptionForm.ERROR_CODE.EXIST, "Ingredient is not exist");
        }
        Store store = storeReponsitory.findOne(storeId);
        Ingredient ingredient = ingredientRepository.findOne(ingredientId);

        StoreIngredient storeIngredient = new StoreIngredient(store, ingredient);
        return storeIngredient;
    }


    public StoreIngredient update(int id, int storeId, int ingredientId){
        if(!storeIngredientRepository.exists(id)){
            throw new ExceptionForm("Store ingredient", ExceptionForm.ERROR_CODE.EXIST, "Store ingredient is not exist");
        }
        if(!storeReponsitory.exists(storeId)){
            throw new ExceptionForm("Store", ExceptionForm.ERROR_CODE.EXIST, "Store is not exist");
        }
        if(!ingredientRepository.exists(ingredientId)){
            throw new ExceptionForm("Ingredient", ExceptionForm.ERROR_CODE.EXIST, "Ingredient is not exist");
        }
        StoreIngredient storeIngredient = storeIngredientRepository.findOne(id);
        Store store = storeReponsitory.findOne(storeId);
        Ingredient ingredient = ingredientRepository.findOne(ingredientId);
        storeIngredient.setIngredient(ingredient);
        storeIngredient.setStore(store);

        return storeIngredient;
    }


    public ResponseEntity delete(int id){
        if(!storeIngredientRepository.exists(id)){
            throw new ExceptionForm("Store ingredient", ExceptionForm.ERROR_CODE.EXIST, "Store ingredient is not exist");
        }
        storeIngredientRepository.delete(id);
        return ResponseEntity.ok("Delete " + id + " successfully");
    }


}

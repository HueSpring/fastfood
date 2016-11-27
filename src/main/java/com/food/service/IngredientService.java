package com.food.service;

import com.food.common.Common;
import com.food.exception.ExceptionForm;
import com.food.model.Ingredient;
import com.food.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Hue on 11/12/2016.
 */
@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;


    /**
     * find all ingredient
     * @return
     */
    public Iterable<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    /**
     * create ingredient
     * @param name
     * @param price
     * @param image
     * @return
     */
    public Ingredient save(String name, String image, String unit, int price) {
        if (ingredientRepository.findName(name) != null) {
            throw new ExceptionForm("name", ExceptionForm.ERROR_CODE.EXIST, "name's ingredient is already exist");
        }
        Ingredient ingredient = new Ingredient(name, image, unit);
        return ingredientRepository.save(ingredient);
    }

    /**
     * update ingredient
     * @param id
     * @param name
     * @param image
     * @param unit
     * @return
     */
    public Ingredient update(int id, String name, String image, String unit){
        if(!ingredientRepository.exists(id)){
            throw new ExceptionForm("ingredient", ExceptionForm.ERROR_CODE.EXIST, "ingredient is not exist");
        }
        if (ingredientRepository.findName(name) != null) {
            throw new ExceptionForm("name", ExceptionForm.ERROR_CODE.EXIST, "name's ingredient is already exist");
        }
        Ingredient ingredient = ingredientRepository.findOne(id);
        ingredient.setName(name);
        ingredient.setImage(image);
        ingredient.setUnit(unit);
        return ingredientRepository.save(ingredient);
    }


    public Ingredient findOne(int id) {
        if (!ingredientRepository.exists(id)) {
            throw new ExceptionForm("id", ExceptionForm.ERROR_CODE.EXIST, "ingredient is not exist");
        }
        return ingredientRepository.findOne(id);
    }


    public ResponseEntity delete(int id){
        if (!ingredientRepository.exists(id)) {
            throw new ExceptionForm("id", ExceptionForm.ERROR_CODE.EXIST, "ingredient is not exist");
        }
        ingredientRepository.delete(id);
        return ResponseEntity.ok("success");
    }



}

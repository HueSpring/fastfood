package com.food.service;

import com.food.exception.ExceptionForm;
import com.food.model.Food;
import com.food.model.FoodIngredient;
import com.food.model.Ingredient;
import com.food.model.Unit;
import com.food.repository.FoodIngredientRepository;
import com.food.repository.FoodRepository;
import com.food.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Hue on 11/13/2016.
 */
@Service
public class FoodIngredientService {

    @Autowired
    private FoodIngredientRepository foodIngredientRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    public FoodIngredient save(int quantity, String unit, int foodId, int ingredientId) {
        if (!foodRepository.exists(foodId)) {
            throw new ExceptionForm("food", ExceptionForm.ERROR_CODE.EXIST, "food is not exist");
        } else if (!ingredientRepository.exists(ingredientId)) {
            throw new ExceptionForm("ingredient", ExceptionForm.ERROR_CODE.EXIST, "ingredient is not exist");
        }
        Food food = foodRepository.findOne(foodId);
        Ingredient ingredient = ingredientRepository.findOne(ingredientId);
        FoodIngredient foodIngredient = new FoodIngredient(quantity, unit, ingredient, food);
        return foodIngredientRepository.save(foodIngredient);
    }


    /**
     * update
     *
     * @param id
     * @param quantity
     * @param unit
     * @param foodId
     * @param ingredientId
     * @return
     */
    public FoodIngredient update(int id, int quantity, String unit, int foodId, int ingredientId) {
        if (!foodIngredientRepository.exists(id)) {
            throw new ExceptionForm("food's ingredient", ExceptionForm.ERROR_CODE.EXIST, "Food's ingerdient is not exist");
        }
        if (!foodRepository.exists(foodId)) {
            throw new ExceptionForm("food", ExceptionForm.ERROR_CODE.EXIST, "food is not exist");
        }
        if (!ingredientRepository.exists(ingredientId)) {
            throw new ExceptionForm("ingredient", ExceptionForm.ERROR_CODE.EXIST, "ingredient is not exist");
        }
        Food food = foodRepository.findOne(foodId);
        Ingredient ingredient = ingredientRepository.findOne(ingredientId);
        FoodIngredient foodIngredient = foodIngredientRepository.findOne(id);
        foodIngredient.setQuantity(quantity);
        foodIngredient.setUnit(unit);
        foodIngredient.setFood(food);
        foodIngredient.setIngredient(ingredient);
        return foodIngredientRepository.save(foodIngredient);
    }

    /**
     * find all
     *
     * @return
     */
    public Iterable<FoodIngredient> findAll() {
        Iterable<FoodIngredient> list = foodIngredientRepository.findAll();
        if (list == null) {
            throw new ExceptionForm("food's ingredients", ExceptionForm.ERROR_CODE.EXIST, "Not found");
        }
        return list;
    }

    public FoodIngredient findOne(int id) {
        if (!foodIngredientRepository.exists(id)) {
            throw new ExceptionForm("food's ingredient", ExceptionForm.ERROR_CODE.EXIST, "Food's ingredient is not exist");
        }
        return foodIngredientRepository.findOne(id);
    }


    public Iterable<FoodIngredient> findIngredientByFood(int id) {
        if (!foodRepository.exists(id)) {
            throw new ExceptionForm("food", ExceptionForm.ERROR_CODE.EXIST, "Food is not exist");
        }
        return foodIngredientRepository.findIngredientByFood(id);
    }


}

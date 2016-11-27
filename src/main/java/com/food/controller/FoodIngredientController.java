package com.food.controller;

import com.food.exception.ExceptionForm;
import com.food.form.FoodIngredientForm;
import com.food.model.FoodIngredient;
import com.food.service.FoodIngredientService;
import com.food.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by Hue on 11/13/2016.
 */
@RestController
@RequestMapping(value = "/{key}/food/ingredient")
public class FoodIngredientController {

    @Autowired
    private FoodIngredientService foodIngredientService;

    @Autowired
    private PermissionService permissionService;

    public FoodIngredientController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<FoodIngredient> findAll() {
        return foodIngredientService.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public FoodIngredient save(@PathVariable(value = "key") String key, @Valid @RequestBody FoodIngredientForm form, BindingResult bindingResult) {
        permissionService.permission(permissionService.FOOD_ADD, key);
        if (bindingResult.hasErrors()) {
            throw new ExceptionForm(bindingResult);
        }
        return foodIngredientService.save(form.getQuantity(), form.getUnit(), form.getFoodId(), form.getIngredientId());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public FoodIngredient update(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id, @Valid @RequestBody FoodIngredientForm form, BindingResult bindingResult) {
        permissionService.permission(permissionService.FOOD_UPDATE, key);
        if (bindingResult.hasErrors()) {
            throw new ExceptionForm(bindingResult);
        }
        return foodIngredientService.update(id, form.getQuantity(), form.getUnit(), form.getFoodId(), form.getIngredientId());
    }

    @RequestMapping(value = "/by/{id}", method = RequestMethod.GET)
    public Iterable<FoodIngredient> findIngredientByFood(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id) {
        permissionService.permission(permissionService.FOOD_VIEW, key);
        return foodIngredientService.findIngredientByFood(id);
    }



}

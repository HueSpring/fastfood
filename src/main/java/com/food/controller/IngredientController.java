package com.food.controller;

import com.food.exception.ExceptionForm;
import com.food.form.IngredientForm;
import com.food.model.Ingredient;
import com.food.service.IngredientService;
import com.food.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Hue on 11/12/2016.
 */
@RestController
@RequestMapping(value = "/{key}/ingredient")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private PermissionService permissionService;

    public IngredientController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Ingredient> findAll(@PathVariable(value = "key") String key) {
        permissionService.permission(permissionService.INGREDIENT_VIEW, key);
        return ingredientService.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Ingredient save(@PathVariable(value = "key") String key, @Valid @RequestBody IngredientForm form, BindingResult bindingResult) {
        permissionService.permission(permissionService.INGREDIENT_ADD, key);
        if (bindingResult.hasErrors()) {
            throw new ExceptionForm(bindingResult);
        }
        return ingredientService.save(form.getName(), form.getImage(), form.getUnit(), form.getPrice());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Ingredient update(@PathVariable(value = "key") String key, @PathVariable(name = "id") int id, @Valid @RequestBody IngredientForm form, BindingResult bindingResult) {
        permissionService.permission(permissionService.INGREDIENT_UPDATE, key);
        if (bindingResult.hasErrors()) {
            throw new ExceptionForm((bindingResult));
        }
        return ingredientService.update(id, form.getName(), form.getImage(), form.getUnit());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Ingredient findOne(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id) {
        permissionService.permission(permissionService.INGREDIENT_VIEW, key);
        return ingredientService.findOne(id);
    }


}

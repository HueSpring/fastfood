package com.food.controller;

import com.food.exception.ExceptionForm;
import com.food.form.FoodForm;
import com.food.model.Food;
import com.food.service.FoodService;
import com.food.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Hue on 11/12/2016.
 */
@RestController
@RequestMapping(value = {"/{key}/food"})
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private PermissionService permissionService;

    public FoodController() {
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Food saveType(@PathVariable(value = "key") String key, @Valid @RequestBody FoodForm form, BindingResult bindingResult) {
        permissionService.permission(permissionService.FOOD_ADD, key);
        if (bindingResult.hasErrors()) {
            throw new ExceptionForm(bindingResult);
        }
        return foodService.saveType(form.getName(), form.getPrice(), form.getImage(), form.getFoodTypeId());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Food update(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id, @Valid @RequestBody FoodForm form, BindingResult bindingResult) {
        permissionService.permission(permissionService.FOOD_UPDATE, key);
        if (bindingResult.hasErrors()) {
            throw new ExceptionForm(bindingResult);
        }
        return foodService.update(id, form.getName(), form.getPrice(), form.getImage());
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Food> findAll(@PathVariable(value = "key") String key) {
//        permissionService.permission(permissionService.FOOD_VIEW, key);
        return foodService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id) {
        permissionService.permission(permissionService.FOOD_DELETE, key);
        return foodService.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Food findOne(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id){
//        permissionService.permission(permissionService.FOOD_VIEW, key);
        return foodService.findOne(id);
    }

    @RequestMapping(value = "/by/{id}", method = RequestMethod.GET)
    public Iterable<Food> findByType(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id){
//        permissionService.permission(permissionService.FOOD_VIEW, key);
        return foodService.findByType(id);
    }

}

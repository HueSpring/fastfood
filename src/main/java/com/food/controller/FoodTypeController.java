package com.food.controller;

import com.food.exception.ExceptionForm;
import com.food.model.FoodType;
import com.food.service.FoodTypeService;
import com.food.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by Hue on 11/16/2016.
 */
@RestController
@RequestMapping(value = "/{key}/food/type")
public class FoodTypeController {

    @Autowired
    private FoodTypeService foodTypeService;

    @Autowired
    private PermissionService permissionService;

    public FoodTypeController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<FoodType> findAll(@PathVariable(value = "key") String key){
        permissionService.permission(permissionService.FOOD_VIEW, key);
        return foodTypeService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public FoodType findOne(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id){
        permissionService.permission(permissionService.FOOD_VIEW, key);
        return foodTypeService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public FoodType save(@PathVariable(value = "key") String key, @Valid @RequestParam String name){
        permissionService.permission(permissionService.FOOD_VIEW, key);
        if(name == null || name.trim().equals("") || name.length() <= 50){
            throw new ExceptionForm("Name", ExceptionForm.ERROR_CODE.INVALID, "Name is invalid");
        }
        return foodTypeService.save(name);
    }



}

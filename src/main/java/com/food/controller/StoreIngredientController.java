package com.food.controller;

import com.food.exception.ExceptionForm;
import com.food.form.StoreIngredientForm;
import com.food.model.StoreIngredient;
import com.food.service.PermissionService;
import com.food.service.StoreIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Hue on 11/24/2016.
 */
@RestController
@RequestMapping(value = "/{key}/ingredient/store")
public class StoreIngredientController {


    @Autowired
    private StoreIngredientService storeIngredientService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<StoreIngredient> findAll(@PathVariable(value = "key") String key) {
        permissionService.permission(permissionService.STORE_VIEW, key);
        return storeIngredientService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public StoreIngredient findOne(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id) {
        permissionService.permission(permissionService.STORE_VIEW, key);
        return storeIngredientService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public StoreIngredient save(@PathVariable(value = "key") String key, @Valid @RequestBody StoreIngredientForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ExceptionForm(bindingResult);
        }
        permissionService.permission(permissionService.STORE_ADD, key);
        return storeIngredientService.save(form.getStoreId(), form.getIngredientId());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public StoreIngredient update(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id, @Valid @RequestBody StoreIngredientForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ExceptionForm(bindingResult);
        }
        permissionService.permission(permissionService.STORE_UPDATE, key);
        return storeIngredientService.update(id, form.getStoreId(), form.getIngredientId());
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id) {
        permissionService.permission(permissionService.STORE_DELETE, key);
        return storeIngredientService.delete(id);
    }


}




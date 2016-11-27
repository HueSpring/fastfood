package com.food.controller;

import com.food.exception.ExceptionForm;
import com.food.form.StoreForm;
import com.food.model.Store;
import com.food.model.User;
import com.food.service.PermissionService;
import com.food.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Hue on 11/7/2016.
 */
@RestController
@RequestMapping(value = "/{key}/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private PermissionService permissionService;

    public StoreController() {
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Store save(@PathVariable(value = "key") String key, @Valid @RequestBody StoreForm form, BindingResult bindingResult) {
        permissionService.permission(permissionService.STORE_ADD, key);
        if (bindingResult.hasErrors()) {
            throw new ExceptionForm(bindingResult);
        }
        return storeService.save(form.getName(), form.getNoStreet(), form.getDistrict());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Store update(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id, @Valid @RequestBody StoreForm form, BindingResult bindingResult) {
        permissionService.permission(permissionService.STORE_UPDATE, key);
        if (bindingResult.hasErrors()) {
            throw new ExceptionForm(bindingResult);
        }
        return storeService.update(id, form.getName(), form.getNoStreet(), form.getDistrict());
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Store> findAll(@PathVariable(value = "key") String key) {
        permissionService.permission(permissionService.STORE_VIEW, key);
        return storeService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id) {
        permissionService.permission(permissionService.STORE_DELETE, key);
        return storeService.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Store findOne(int id) {
        return storeService.findOne(id);
    }

    @RequestMapping(value = "/count/{id}", method = RequestMethod.GET)
    public Long countEmp(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id){
        return storeService.countEmp(id);
    }





}

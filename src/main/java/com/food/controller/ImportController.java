package com.food.controller;

import com.food.exception.ExceptionForm;
import com.food.form.LoginForm;
import com.food.model.Import;
import com.food.service.ImportService;
import com.food.service.PermissionService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Hue on 11/13/2016.
 */
@RestController
@RequestMapping(value = "/{key}/import")
public class ImportController {

    @Autowired
    private ImportService importService;

    @Autowired
    private PermissionService permissionService;

    public ImportController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Import> findAll(@PathVariable(value = "key") String key) {
        permissionService.permission(permissionService.INGREDIENT_VIEW, key);
        return importService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Import findOne(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id){
        permissionService.permission(permissionService.IMPORT_VIEW, key);
        return importService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Import save(@PathVariable(value = "key") String key, @RequestBody LoginForm form){
        permissionService.permission(permissionService.IMPORT_ADD, key);
        return importService.save(form.getId());
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id){
        permissionService.permission(permissionService.IMPORT_DELETE, key);
        return importService.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public Import updatePay(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id){
        permissionService.permission(permissionService.IMPORT_UPDATE, key);
        return importService.updatePay(id, true);
    }

}

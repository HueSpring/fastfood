package com.food.controller;

import com.food.exception.ExceptionForm;
import com.food.form.ImportIngredientForm;
import com.food.model.ImportIngredient;
import com.food.service.ImportIngredientService;
import com.food.service.PermissionService;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Hue on 11/23/2016.
 */
@RestController
@RequestMapping(value = "/{key}/ingredient/import")
public class ImportIngredientController {

    @Autowired
    private ImportIngredientService importIngredientService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/day-near", method = RequestMethod.GET)
    public Iterable<ImportIngredient> findAllNearDate(@PathVariable(value = "key") String key){
        permissionService.permission(permissionService.IMPORT_EXPORT_VIEW, key);
        return importIngredientService.findAllNearDate();
    }

    @RequestMapping(value = "/quantity-near", method = RequestMethod.GET)
    public Iterable<ImportIngredient> findAllNearQuantity(@PathVariable(value = "key") String key){
        permissionService.permission(permissionService.IMPORT_EXPORT_VIEW, key);
        return importIngredientService.findAllNearQuantity();
    }

    @RequestMapping(value = "/use", method = RequestMethod.GET)
    public Iterable<ImportIngredient> findAllUse(@PathVariable(value = "key") String key){
        permissionService.permission(permissionService.IMPORT_EXPORT_VIEW, key);
        return importIngredientService.findAllUse();
    }

    @RequestMapping(value = "/quantity-end", method = RequestMethod.GET)
    public Iterable<ImportIngredient> findAllEndQuantity(@PathVariable(value = "key") String key){
        permissionService.permission(permissionService.IMPORT_EXPORT_VIEW, key);
        return importIngredientService.findAllEndQuantity();
    }

    @RequestMapping(value = "/day-end", method = RequestMethod.GET)
    public Iterable<ImportIngredient> findAllEndDate(@PathVariable(value = "key") String key){
        permissionService.permission(permissionService.IMPORT_EXPORT_VIEW, key);
        return importIngredientService.findAllEndDateNoQuantity();
    }


    @RequestMapping(method = RequestMethod.PUT)
    public ImportIngredient save(@PathVariable(value = "key") String key, @Valid @RequestBody ImportIngredientForm form, BindingResult bindingResult){
        permissionService.permission(permissionService.IMPORT_EXPORT_ADD, key);
        if(bindingResult.hasErrors()){
            throw new ExceptionForm(bindingResult);
        }
        return importIngredientService.save(form.getQuantiy(), form.getPrice(), form.getDateEnd(), form.getUnit(), form.getIngredientId(), form.getImportId());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ImportIngredient update(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id,
                                   @Valid @RequestBody ImportIngredientForm form, BindingResult bindingResult){
        permissionService.permission(permissionService.IMPORT_EXPORT_UPDATE, key);
        if(bindingResult.hasErrors()){
            throw new ExceptionForm(bindingResult);
        }
        return importIngredientService.update(id, form.getQuantiy(), form.getPrice(), form.getDateEnd(), form.getUnit(), form.getIngredientId(), form.getImportId());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    private ResponseEntity delete(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id){
        permissionService.permission(permissionService.IMPORT_EXPORT_DELETE, key);
        return importIngredientService.delete(id);
    }

}

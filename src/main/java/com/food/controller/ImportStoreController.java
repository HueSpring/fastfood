package com.food.controller;

import com.food.exception.ExceptionForm;
import com.food.form.ImportForm;
import com.food.form.LoginForm;
import com.food.form.UserForm;
import com.food.model.ImportStore;
import com.food.service.ImportStoreService;
import com.food.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Hue on 11/25/2016.
 */
@RestController
@RequestMapping(value = "/{key}/store/import")
public class ImportStoreController {

    @Autowired
    private ImportStoreService importStoreService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(method = RequestMethod.PUT)
    public ImportStore save(@PathVariable(value = "key") String key, @Valid @RequestBody ImportForm form, BindingResult bindingResult){
        permissionService.permission(permissionService.IMPORT_EXPORT_ADD, key);
        if(bindingResult.hasErrors()){
            throw new ExceptionForm(bindingResult);
        }
        return importStoreService.save(form.getId1(), form.getId2());
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id){
        permissionService.permission(permissionService.IMPORT_EXPORT_DELETE, key);
        return importStoreService.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public ImportStore updatePay(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id){
        permissionService.permission(permissionService.IMPORT_EXPORT_UPDATE, key);
        return importStoreService.updatePay(id, true);
    }


}

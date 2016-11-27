package com.food.controller;

import com.food.exception.ExceptionForm;
import com.food.form.LoginForm;
import com.food.form.PassForm;
import com.food.form.UserForm;
import com.food.model.User;
import com.food.service.AccountService;
import com.food.service.PermissionService;
import com.food.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;

/**
 * Created by Hue on 10/31/2016.
 */
@RestController
@RequestMapping(value = "/{key}/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    public UserController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<User> findAll(@PathVariable(value = "key") String key) {
        permissionService.permission(permissionService.USER_VIEW, key);
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findOne(@PathVariable(value = "key") String key, @PathVariable(value = "id") String id) {
        permissionService.permission(permissionService.USER_VIEW, key);
        return userService.findOne(id);
    }

    public User findOne(String id) {
        return userService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public User save(@PathVariable(value = "key") String key, @Valid @RequestBody UserForm form, BindingResult bindingResult) {
        permissionService.permission(PermissionService.USER_ADD, key);
        if (bindingResult.hasErrors()) {
            throw new ExceptionForm(bindingResult);
        }
        return userService.save(form.getId(), form.getFirstName(), form.getLastName(), form.getDob(), form.getAddress(),
                form.getPhone(), form.getEmail(), form.getStoreId(), form.getRoleId());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public User update(@PathVariable(value = "key") String key, @PathVariable(value = "id") String id, @Valid @RequestBody UserForm form, BindingResult bindingResult) {
        permissionService.permission(PermissionService.USER_UPDATE, key);
        if (bindingResult.hasErrors()) {
            throw new ExceptionForm(bindingResult);
        }
        return userService.update(key, id, form.getFirstName(), form.getLastName(), form.getDob(), form.getAddress(),
                form.getPhone(), form.getEmail(), form.getStoreId(), form.getRoleId());
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public User updateOwn(@PathVariable(value = "key") String key, @Valid @RequestBody UserForm form, BindingResult bindingResult) {
        permissionService.permission(PermissionService.USER_UPDATE, key);
        if (bindingResult.hasErrors()) {
            throw new ExceptionForm(bindingResult);
        }
        return userService.updateOwner(key, form.getId(), form.getFirstName(), form.getLastName(), form.getDob(), form.getAddress(),
                form.getPhone(), form.getEmail());
    }

    @RequestMapping(value = "/pass", method = RequestMethod.POST)
    public User updatePass(@PathVariable(value = "key") String key, @Valid @RequestBody PassForm form, BindingResult bindingResult) {
        permissionService.permission(PermissionService.USER_UPDATE, key);
        if (bindingResult.hasErrors()) {
            throw new ExceptionForm(bindingResult);
        }
        return userService.updatePass(key, form.getPassOld(), form.getPassNew(), form.getPassRep());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable(value = "key") String key, @PathVariable(value = "id") String id) {
        permissionService.permission(PermissionService.USER_DELETE, key);
        return userService.delete(id);
    }

    @RequestMapping(value = "/de/{id}", method = RequestMethod.DELETE)
    public User de(@PathVariable(value = "key") String key, @PathVariable(value = "id") String id) {
        permissionService.permission(PermissionService.USER_DELETE, key);
        return userService.updateDe(id);
    }

    @RequestMapping(value = "/active/{id}", method = RequestMethod.DELETE)
    public User active(@PathVariable(value = "key") String key, @PathVariable(value = "id") String id) {
        permissionService.permission(PermissionService.USER_DELETE, key);
        return userService.updateActive(id);
    }

    @RequestMapping(value = "/{id}/{storeId}", method = RequestMethod.GET)
    public User addStore(@PathVariable(value = "key") String key, @PathVariable(value = "id") String id, @PathVariable(value = "storeId") int storeId) {
        permissionService.permission(permissionService.USER_UPDATE, key);
        return userService.addStore(id, storeId);
    }

    @RequestMapping(value = "/de", method = RequestMethod.GET)
    public Iterable<User> findDeactive(@PathVariable(value = "key") String key) {
        permissionService.permission(permissionService.USER_VIEW, key);
        return userService.findDeactive();
    }

    @RequestMapping(value = "/active", method = RequestMethod.GET)
    public Iterable<User> findActive(@PathVariable(value = "key") String key) {
        permissionService.permission(permissionService.USER_VIEW, key);
        return userService.findActive();
    }
}

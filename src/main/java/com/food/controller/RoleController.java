package com.food.controller;

import com.food.model.Role;
import com.food.service.PermissionService;
import com.food.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Hue on 11/16/2016.
 */
@RestController
@RequestMapping(value = "/{key}/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    public RoleController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Role> findAll(@PathVariable(value = "key") String key) {
        permissionService.permission(permissionService.USER_VIEW, key);
        return roleService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Role findOne(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id) {
        permissionService.permission(permissionService.USER_VIEW, key);
        return roleService.findOne(id);
    }


}

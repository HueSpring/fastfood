package com.food.controller;

import com.food.form.LoginForm;
import com.food.form.UserForm;
import com.food.model.Book;
import com.food.service.OrderService;
import com.food.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Hue on 11/15/2016.
 */
@RestController
@RequestMapping(value = "/{key}/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PermissionService permissionService;

    public OrderController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Book> findAll(@PathVariable(value = "key") String key) {
        permissionService.permission(permissionService.ORDER_VIEW, key);
        return orderService.findAll();
    }

    //find by 2 status
    @RequestMapping(value = "/online/no-use", method = RequestMethod.GET)
    public Iterable<Book> findAllByStatus(@PathVariable(value = "key") String key) {
        permissionService.permission(permissionService.ORDER_VIEW, key);
        return orderService.findAllOnlineNoUse();
    }

    //find by 2 status
    @RequestMapping(value = "/online/no-use-time", method = RequestMethod.POST)
    public Iterable<Book> findAllBy2StatusTime(@PathVariable(value = "key") String key, @RequestBody UserForm form) {
        permissionService.permission(permissionService.ORDER_VIEW, key);
        return orderService.findAllOnlineNoUseTime(form.getDob());
    }

    //find by 1 status
    @RequestMapping(value = "/online/no-check", method = RequestMethod.GET)
    public Iterable<Book> findAllByStatusNoCheck(@PathVariable(value = "key") String key) {
        permissionService.permission(permissionService.ORDER_VIEW, key);
        return orderService.findAllOnlineNoUse1();
    }

    //find by 1 status
    @RequestMapping(value = "/online/no-check-time", method = RequestMethod.POST)
    public Iterable<Book> findAllBy1StatusTimeNoCheck(@PathVariable(value = "key") String key, @RequestBody UserForm form) {
        permissionService.permission(permissionService.ORDER_VIEW, key);
        return orderService.findAllOnlineNoUseTime1(form.getDob());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book findOne(@PathVariable(value = "key") String key, @PathVariable(value = "id") String id) {
        permissionService.permission(permissionService.ORDER_VIEW, key);
        return orderService.findOne(id);
    }


}

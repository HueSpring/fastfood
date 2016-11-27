package com.food.controller;

import com.food.exception.ExceptionForm;
import com.food.form.SalaryMonthStoreForm;
import com.food.model.Salary;
import com.food.service.PermissionService;
import com.food.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Hue on 11/15/2016.
 */
@RestController
@RequestMapping(value = "/{key}/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @Autowired
    private PermissionService permissionService;

    public SalaryController() {
    }

    @RequestMapping(value = "/month-store", method = RequestMethod.POST)
    public Iterable<Salary> findMonthStore(@PathVariable(value = "key") String key, @Valid @RequestBody SalaryMonthStoreForm form, BindingResult bindingResult){
        permissionService.permission(permissionService.SALARY_VIEW, key);
        if(bindingResult.hasErrors()){
            throw new ExceptionForm(bindingResult);
        }
        return salaryService.findMonthStore(form.getMonth(), form.getYear(), form.getStoreId());
    }

    @RequestMapping(value = "/done", method = RequestMethod.GET)
    public Iterable<Salary> findAllStatus(@PathVariable(value = "key") String key){
        permissionService.permission(permissionService.SALARY_VIEW, key);
        return salaryService.findAllStatus();
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Salary> findAll(@PathVariable(value = "key") String key){
        permissionService.permission(permissionService.SALARY_VIEW, key);
        return salaryService.findAll();
    }


}

package com.food.service;

import com.food.exception.ExceptionForm;
import com.food.model.Role;
import com.food.repository.RoleReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Hue on 10/31/2016.
 */
@Service
public class RoleService {

    @Autowired
    private RoleReponsitory roleReponsitory;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Role> findAll(){
        Iterable<Role> list = roleReponsitory.findAll();
        if(list == null){
            throw new ExceptionForm("Role", ExceptionForm.ERROR_CODE.EXIST, "Not found");
        }
        return list;
    }


    public Role findOne(int id){
        if(!roleReponsitory.exists(id)){
            throw new ExceptionForm("Role", ExceptionForm.ERROR_CODE.EXIST, "Role is not exist");
        }
        return roleReponsitory.findOne(id);
    }


}

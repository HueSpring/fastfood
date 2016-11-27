package com.food.controller;

import com.food.model.User;
import com.food.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by Hue on 11/27/2016.
 */
@RestController
public class DemoController {

    @Autowired
    private UserRepository userRepository;

    public DemoController() {
    }

    @RequestMapping(value = "/uu", method = RequestMethod.GET)
    public Set<User> findUser(){
        return userRepository.findUser();
    }

}

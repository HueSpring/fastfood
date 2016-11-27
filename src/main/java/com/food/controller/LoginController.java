package com.food.controller;

import com.food.exception.ExceptionForm;
import com.food.form.LoginForm;
import com.food.model.User;
import com.food.repository.UserRepository;
import com.food.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Hue on 11/14/2016.
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public LoginController() {
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ResponseEntity login(@Valid @RequestBody LoginForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ExceptionForm(bindingResult);
        }
        User user = userService.login(form.getId(), form.getPassword());
        HttpHeaders headers = new HttpHeaders();
        headers.set("key", user.getKeyCode());
        return new ResponseEntity(user, headers, HttpStatus.OK);
    }

}

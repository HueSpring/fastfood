package com.food.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Hue on 11/13/2016.
 */
public class LoginForm {

    @NotBlank
    @Length(max = 10)
    private String id;
    @NotBlank
    @Length(max = 50)
    private String password;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}



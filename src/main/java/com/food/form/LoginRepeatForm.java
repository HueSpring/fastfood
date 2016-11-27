package com.food.form;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Hue on 11/5/2016.
 */
public class LoginRepeatForm {

    @NotBlank
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

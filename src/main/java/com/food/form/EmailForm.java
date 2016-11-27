package com.food.form;

import org.hibernate.validator.constraints.Email;

/**
 * Created by Hue on 11/26/2016.
 */

public class EmailForm {

    @Email
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

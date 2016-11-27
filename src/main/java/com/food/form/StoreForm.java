package com.food.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

/**
 * Created by Hue on 11/12/2016.
 */
public class StoreForm {

    @NotNull
    @Length(max = 50)
    private String name;
    @NotNull
    @Length(max = 50)
    private String noStreet;
    @NotNull
    @Length(max = 50)
    private String district;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoStreet() {
        return noStreet;
    }

    public void setNoStreet(String noStreet) {
        this.noStreet = noStreet;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

}

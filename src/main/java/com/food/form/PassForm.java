package com.food.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by Hue on 11/16/2016.
 */
public class PassForm {

    @NotBlank
    @Length(max = 50, min = 6)
    private String passOld;
    @NotBlank
    @Length(max = 50, min = 6)
    private String passNew;
    @NotBlank
    @Length(max = 50, min = 6)
    private String passRep;

    public String getPassOld() {
        return passOld;
    }

    public void setPassOld(String passOld) {
        this.passOld = passOld;
    }

    public String getPassNew() {
        return passNew;
    }

    public void setPassNew(String passNew) {
        this.passNew = passNew;
    }

    public String getPassRep() {
        return passRep;
    }

    public void setPassRep(String passRep) {
        this.passRep = passRep;
    }
}

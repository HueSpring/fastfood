package com.food.form;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by Hue on 11/15/2016.
 */
public class SalaryMonthStoreForm {

    @NumberFormat
    @Max(12)
    private int month;
    @NumberFormat
    @Max(4000)
    private int year;
    @NumberFormat
    private int storeId;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
}

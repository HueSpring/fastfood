package com.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Hue on 10/31/2016.
 */
@Entity
@Table(name = "salary")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int month;
    private int year;
    private int salary;
    private boolean status;
    private String dateReceive;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Salary() {
    }

    public Salary(int month, int year, int salary, boolean status, String dateReceive) {
        this.month = month;
        this.year = year;
        this.salary = salary;
        this.status = status;
        this.dateReceive = dateReceive;
    }

    public Salary(User user, int month, int year, int salary, boolean status, String dateReceive) {
        this.user = user;
        this.month = month;
        this.year = year;
        this.salary = salary;
        this.status = status;
        this.dateReceive = dateReceive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDateReceive() {
        return dateReceive;
    }

    public void setDateReceive(String dateReceive) {
        this.dateReceive = dateReceive;
    }
}

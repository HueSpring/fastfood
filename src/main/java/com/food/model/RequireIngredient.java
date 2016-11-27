package com.food.model;

import javax.persistence.*;

/**
 * Created by Hue on 11/10/2016.
 */
@Entity
@Table(name = "require_ingredient")
public class RequireIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String description;

    private boolean statusRequire;

    private boolean statusInspection;
    private boolean statusSuccess;
    private int quantity;
    private String note;
    private String dateCreated;
    private String dateAccepted;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "store_ingredient_id")
    private StoreIngredient storeIngredient;

    public RequireIngredient() {
    }

    public RequireIngredient(String description, boolean statusRequire, boolean statusInspection, boolean statusSuccess, int quantity, String note, String dateCreated, String dateAccepted, User user, StoreIngredient storeIngredient) {
        this.description = description;
        this.statusRequire = statusRequire;
        this.statusInspection = statusInspection;
        this.statusSuccess = statusSuccess;
        this.quantity = quantity;
        this.note = note;
        this.dateCreated = dateCreated;
        this.dateAccepted = dateAccepted;
        this.user = user;
        this.storeIngredient = storeIngredient;
    }

    public RequireIngredient(String description, boolean statusRequire, boolean statusInspection, boolean statusSuccess, int quantity, String note, String dateCreated, String dateAccepted) {
        this.description = description;
        this.statusRequire = statusRequire;
        this.statusInspection = statusInspection;
        this.statusSuccess = statusSuccess;
        this.quantity = quantity;
        this.note = note;
        this.dateCreated = dateCreated;
        this.dateAccepted = dateAccepted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatusRequire() {
        return statusRequire;
    }

    public void setStatusRequire(boolean statusRequire) {
        this.statusRequire = statusRequire;
    }

    public boolean isStatusInspection() {
        return statusInspection;
    }

    public void setStatusInspection(boolean statusInspection) {
        this.statusInspection = statusInspection;
    }

    public boolean isStatusSuccess() {
        return statusSuccess;
    }

    public void setStatusSuccess(boolean statusSuccess) {
        this.statusSuccess = statusSuccess;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateAccepted() {
        return dateAccepted;
    }

    public void setDateAccepted(String dateAccepted) {
        this.dateAccepted = dateAccepted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public StoreIngredient getStoreIngredient() {
        return storeIngredient;
    }

    public void setStoreIngredient(StoreIngredient storeIngredient) {
        this.storeIngredient = storeIngredient;
    }
}
package com.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hue on 11/13/2016.
 */
@Entity
@Table(name = "import_ingredient")
public class ImportIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int quantity;
    private int price;
    private String dateEnd;
    private String unit;

    @ManyToOne
    @JoinColumn(name = "import_id")
    private Import anImport;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    public ImportIngredient() {
    }

    public ImportIngredient(int quantity, int price, String dateEnd, String unit) {
        this.quantity = quantity;
        this.price = price;
        this.dateEnd = dateEnd;
        this.unit = unit;
    }

    public ImportIngredient(int quantity, int price, String dateEnd, String unit, Ingredient ingredient, Import anImport) {
        this.quantity = quantity;
        this.price = price;
        this.dateEnd = dateEnd;
        this.unit = unit;
        this.anImport = anImport;
        this.ingredient = ingredient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Import getAnImport() {
        return anImport;
    }

    public void setAnImport(Import anImport) {
        this.anImport = anImport;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

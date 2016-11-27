package com.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Hue on 11/3/2016.
 */
@Entity
@Table(name = "import_store_ingredient")
public class ImportStoreIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String dateEnd;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "store_ingredient_id")
    private StoreIngredient storeIngredient;

    @ManyToOne
    @JoinColumn(name = "import_store_id")
    private ImportStore importStore;

    public ImportStoreIngredient() {
    }

    public ImportStoreIngredient(String dateEnd, int quantity) {
        this.dateEnd = dateEnd;
        this.quantity = quantity;
    }

    public ImportStoreIngredient(String dateEnd, int quantity, StoreIngredient storeIngredient) {
        this.dateEnd = dateEnd;
        this.quantity = quantity;
        this.storeIngredient = storeIngredient;
    }

    public ImportStoreIngredient(String dateEnd, int quantity, StoreIngredient storeIngredient, ImportStore importStore) {
        this.dateEnd = dateEnd;
        this.quantity = quantity;
        this.storeIngredient = storeIngredient;
        this.importStore = importStore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public StoreIngredient getStoreIngredient() {
        return storeIngredient;
    }

    public void setStoreIngredient(StoreIngredient storeIngredient) {
        this.storeIngredient = storeIngredient;
    }

    public ImportStore getImportStore() {
        return importStore;
    }

    public void setImportStore(ImportStore importStore) {
        this.importStore = importStore;
    }
}

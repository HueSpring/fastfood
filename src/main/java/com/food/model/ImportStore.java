package com.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hue on 11/24/2016.
 */
@Entity
@Table(name = "import_store")
public class ImportStore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String dateImport;

    private boolean status;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user1;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_store_id")
    private User user2;

    @OneToMany(mappedBy = "importStore")
    @JsonIgnore
    private Set<ImportStoreIngredient> importStoreIngredients;

    public ImportStore() {
    }


    public ImportStore(String dateImport) {
        this.dateImport = dateImport;
    }

    public ImportStore(String dateImport, User user1, User user2) {
        this.dateImport = dateImport;
        this.user1 = user1;
        this.user2 = user2;
    }

    public ImportStore(String dateImport, User user1, User user2, Set<ImportStoreIngredient> importStoreIngredients) {
        this.dateImport = dateImport;
        this.user1 = user1;
        this.user2 = user2;
        this.importStoreIngredients = importStoreIngredients;
    }

    public Set<ImportStoreIngredient> getImportStoreIngredients() {
        return importStoreIngredients;
    }

    public void setImportStoreIngredients(Set<ImportStoreIngredient> importStoreIngredients) {
        this.importStoreIngredients = importStoreIngredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateImport() {
        return dateImport;
    }

    public void setDateImport(String dateImport) {
        this.dateImport = dateImport;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

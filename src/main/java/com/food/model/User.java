package com.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    private String id;
    @JsonIgnore
    private String pwd;
    private String firstName;
    private String lastName;
    private String dob;
    private String address;
    private String phone;
    private String email;
    private boolean active;
    private String dateCreated;
    @JsonIgnore
    private String keyCode;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Salary> salaries;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Import> imports;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Book> books;

    @OneToMany(mappedBy = "user1")
    @JsonIgnore
    private Set<ImportStore> importStores1;

    @OneToMany(mappedBy = "user2")
    @JsonIgnore
    private Set<ImportStore> importStores2;


    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<RequireIngredient> requireIngredients;

    public User() {
    }

    public User(String id, String pwd, String firstName, String lastName, String dob, String address, String phone, String email, boolean active, String dateCreated, String keyCode) {
        this.id = id;
        this.pwd = pwd;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.active = active;
        this.dateCreated = dateCreated;
        this.keyCode = keyCode;
    }


    public User(String id, String pwd, String firstName, String lastName, String dob, String address, String phone, String email, boolean active, String dateCreated, String keyCode, Role role, Store store) {
        this.id = id;
        this.pwd = pwd;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.active = active;
        this.dateCreated = dateCreated;
        this.keyCode = keyCode;
        this.role = role;
        this.store = store;
    }

    public User(String id, String pwd, String firstName, String lastName, String dob, String address, String phone, String email, boolean active, String dateCreated, String keyCode, Role role, Store store, Set<Salary> salaries) {
        this.id = id;
        this.pwd = pwd;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.active = active;
        this.dateCreated = dateCreated;
        this.keyCode = keyCode;
        this.role = role;
        this.store = store;
        this.salaries = salaries;
    }


    public User(String id, String pwd, String firstName, String lastName, String dob, String address, String phone, String email, boolean active, String dateCreated, String keyCode, Role role, Store store, Set<Salary> salaries, Set<Book> books) {
        this.id = id;
        this.pwd = pwd;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.active = active;
        this.dateCreated = dateCreated;
        this.keyCode = keyCode;
        this.role = role;
        this.store = store;
        this.salaries = salaries;
        this.books = books;
    }

    public User(String id, String pwd, String firstName, String lastName, String dob, String address, String phone, String email, boolean active, String dateCreated, String keyCode, Role role, Store store, Set<Salary> salaries, Set<Import> imports, Set<Book> books, Set<ImportStore> importStores1, Set<ImportStore> importStores2, Set<RequireIngredient> requireIngredients) {
        this.id = id;
        this.pwd = pwd;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.active = active;
        this.dateCreated = dateCreated;
        this.keyCode = keyCode;
        this.role = role;
        this.store = store;
        this.salaries = salaries;
        this.imports = imports;
        this.books = books;
        this.importStores1 = importStores1;
        this.importStores2 = importStores2;
        this.requireIngredients = requireIngredients;
    }

    public Set<RequireIngredient> getRequireIngredients() {
        return requireIngredients;
    }

    public void setRequireIngredients(Set<RequireIngredient> requireIngredients) {
        this.requireIngredients = requireIngredients;
    }

    public Set<ImportStore> getImportStores1() {
        return importStores1;
    }

    public void setImportStores1(Set<ImportStore> importStores1) {
        this.importStores1 = importStores1;
    }

    public Set<ImportStore> getImportStores2() {
        return importStores2;
    }

    public void setImportStores2(Set<ImportStore> importStores2) {
        this.importStores2 = importStores2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Set<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(Set<Salary> salaries) {
        this.salaries = salaries;
    }

    public Set<Import> getImports() {
        return imports;
    }

    public void setImports(Set<Import> imports) {
        this.imports = imports;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}


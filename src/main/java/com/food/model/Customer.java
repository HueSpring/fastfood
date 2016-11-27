package com.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by Hue on 11/16/2016.
 */
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    private String id;
    @JsonIgnore
    private String pwd;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    private String dateCreated;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private Set<Book> books;

    public Customer(String id, String password, String firstName, String lastName, String address, String phone, String email, String dateCreated) {
        this.id = id;
        this.pwd = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.dateCreated = dateCreated;
    }

    public Customer(String id, String password, String firstName, String lastName, String address, String phone, String email, String dateCreated, Set<Book> books) {
        this.id = id;
        this.pwd = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.dateCreated = dateCreated;
        this.books = books;
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

    public void setPwd(String password) {
        this.pwd = password;
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

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}

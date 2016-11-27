package com.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hue on 11/15/2016.
 */
@Entity
@Table(name = "order_type")
public class OrderType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(mappedBy = "orderType")
    @JsonIgnore
    private Set<Book> books;

    public OrderType() {
    }

    public OrderType(String name) {
        this.name = name;
    }

    public OrderType(String name, Set<Book> books) {
        this.name = name;
        this.books = books;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getOrders() {
        return books;
    }

    public void setOrders(Set<Book> orders) {
        this.books = books;
    }
}

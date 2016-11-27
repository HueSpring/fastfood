package com.food.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hue on 11/13/2016.
 */
@Entity
@Table(name = "unit")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(mappedBy = "unit1")
    private Set<UnitConvert> unitConverts1;

    @OneToMany(mappedBy = "unit2")
    private Set<UnitConvert> unitConverts2;

    public Unit() {
    }

    public Unit(String name) {
        this.name = name;
    }

    public Unit(String name, Set<UnitConvert> unitConverts1, Set<UnitConvert> unitConverts2) {
        this.name = name;
        this.unitConverts1 = unitConverts1;
        this.unitConverts2 = unitConverts2;
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

    public Set<UnitConvert> getUnitConverts1() {
        return unitConverts1;
    }

    public void setUnitConverts1(Set<UnitConvert> unitConverts1) {
        this.unitConverts1 = unitConverts1;
    }

    public Set<UnitConvert> getUnitConverts2() {
        return unitConverts2;
    }

    public void setUnitConverts2(Set<UnitConvert> unitConverts2) {
        this.unitConverts2 = unitConverts2;
    }
}

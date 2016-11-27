package com.food.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hue on 11/13/2016.
 */
@Entity
@Table(name = "unit_convert")
public class UnitConvert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int value;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit1;

    @ManyToOne
    @JoinColumn(name = "unit_convert_id")
    private Unit unit2;

    public UnitConvert() {
    }

    public UnitConvert(int value) {
        this.value = value;
    }

    public UnitConvert(int value, Unit unit1, Unit unit2) {
        this.value = value;
        this.unit1 = unit1;
        this.unit2 = unit2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Unit getUnit1() {
        return unit1;
    }

    public void setUnit1(Unit unit1) {
        this.unit1 = unit1;
    }

    public Unit getUnit2() {
        return unit2;
    }

    public void setUnit2(Unit unit2) {
        this.unit2 = unit2;
    }

}

package com.food.repository;

import com.food.model.FoodType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Hue on 11/16/2016.
 */
@Transactional
public interface FoodTypeRepository extends CrudRepository<FoodType, Integer>{

    @Query("SELECT ft.name FROM FoodType ft WHERE ft.name = ?1")
    public String getName(String name);

}

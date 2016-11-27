package com.food.repository;

import com.food.model.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Hue on 11/12/2016.
 */
@Transactional
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

    @Query("SELECT i FROM Ingredient i WHERE i.name = ?1")
    public Ingredient findName(String name);


}

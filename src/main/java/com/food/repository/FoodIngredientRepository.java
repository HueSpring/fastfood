package com.food.repository;

import com.food.model.FoodIngredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Hue on 11/13/2016.
 */
@Transactional
public interface FoodIngredientRepository extends CrudRepository<FoodIngredient, Integer> {

    @Query("SELECT fi FROM FoodIngredient fi JOIN fi.food f WHERE f.id = ?1")
    public Iterable<FoodIngredient> findIngredientByFood(int foodId);


}

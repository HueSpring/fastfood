package com.food.repository;

import com.food.model.Food;
import com.food.model.FoodStore;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Hue on 11/12/2016.
 */
@Transactional
public interface FoodStoreRepository extends CrudRepository<FoodStore, Integer>{

    @Query("SELECT f FROM FoodStore fs JOIN fs.food f WHERE f.id = ?1")
    public Iterable<FoodStore> findByStore(int id);

}

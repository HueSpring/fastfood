package com.food.repository;

import com.food.model.Food;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Hue on 11/12/2016.
 */
@Transactional
public interface FoodRepository extends CrudRepository<Food, Integer>{

    @Query("SELECT f FROM Food f WHERE f.name = ?1")
    public Food findName(String name);

    @Query("SELECT f.name FROM Food f WHERE f.id = ?1")
    public String getName(int id);

    @Query("SELECT f FROM Food f JOIN f.foodType ft WHERE ft.id = ?1")
    public Iterable<Food> findByType(int id);


}

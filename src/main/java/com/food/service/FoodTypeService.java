package com.food.service;

import com.food.exception.ExceptionForm;
import com.food.model.FoodType;
import com.food.repository.FoodTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Hue on 11/16/2016.
 */
@Service
public class FoodTypeService {


    @Autowired
    private FoodTypeRepository foodTypeRepository;


    public Iterable<FoodType> findAll() {
        return foodTypeRepository.findAll();
    }

    public FoodType findOne(int id) {
        return foodTypeRepository.findOne(id);
    }

    public FoodType save(String name) {
        if (foodTypeRepository.getName(name) != null) {
            throw new ExceptionForm("type food", ExceptionForm.ERROR_CODE.EXIST, "Type-food is already exist");
        }
        FoodType foodType = new FoodType(name);
        return foodTypeRepository.save(foodType);
    }



}

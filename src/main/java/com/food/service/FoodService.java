package com.food.service;

import com.food.exception.ExceptionForm;
import com.food.model.Food;
import com.food.model.FoodStore;
import com.food.model.FoodType;
import com.food.model.Ingredient;
import com.food.repository.FoodRepository;
import com.food.repository.FoodStoreRepository;
import com.food.repository.FoodTypeRepository;
import com.food.repository.StoreReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Hue on 11/12/2016.
 */
@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private FoodTypeRepository foodTypeRepository;

    @Autowired
    private FoodStoreRepository foodStoreRepository;

    public Iterable<Food> findAll(){
        return foodRepository.findAll();
    }


    public Food findOne(int id){
        if(!foodRepository.exists(id)){
            throw new ExceptionForm("food", ExceptionForm.ERROR_CODE.EXIST, "Food is not exist");
        }
        return foodRepository.findOne(id);
    }


    public Iterable<Food> findByType(int id){
        if(!foodTypeRepository.exists(id)){
            throw new ExceptionForm("Type food", ExceptionForm.ERROR_CODE.EXIST, "Type-food is not exist");
        }
        return foodRepository.findByType(id);
    }


    public Food save(String name, int price, String image){
        if(foodRepository.findName(name) != null){
            throw new ExceptionForm("name", ExceptionForm.ERROR_CODE.EXIST, "Food is already exist");
        }
        Food food = new Food(name, price, image);
        return foodRepository.save(food);
    }

    public Food saveType(String name, int price, String image, int foodTypeId){
        if(foodRepository.findName(name) != null){
            throw new ExceptionForm("name", ExceptionForm.ERROR_CODE.EXIST, "Food is already exist");
        }
        FoodType foodType = foodTypeRepository.findOne(foodTypeId);
        Food food = new Food(name, price, image, foodType);
        return foodRepository.save(food);
    }


    public Food update(int id, String name, int price, String image){
        if(!foodRepository.exists(id)){
            throw new ExceptionForm("id", ExceptionForm.ERROR_CODE.EXIST, "Food is not exist");
        }
        if(foodRepository.findName(name) != null){
            throw new ExceptionForm("name", ExceptionForm.ERROR_CODE.EXIST, "Food's name is already exist");
        }
        Food food = foodRepository.findOne(id);
        food.setName(name);
        food.setPrice(price);
        food.setImage(image);
        return foodRepository.save(food);
    }

    public ResponseEntity delete(int id){
        if(!foodRepository.exists(id)){
            throw new ExceptionForm("id", ExceptionForm.ERROR_CODE.EXIST, "Food is not exist");
        }
        foodRepository.delete(id);
        Iterable<FoodStore> foodStores = foodStoreRepository.findByStore(id);
        for (FoodStore foodStore: foodStores) {
            foodStore.setStatus(0);
            foodStoreRepository.save(foodStore);
        }
        return ResponseEntity.ok("Food" + foodRepository.getName(id) + "is deleted success");
    }

}

package com.food.service;

import com.food.exception.ExceptionForm;
import com.food.model.Food;
import com.food.model.FoodStore;
import com.food.model.Store;
import com.food.repository.FoodRepository;
import com.food.repository.FoodStoreRepository;
import com.food.repository.StoreReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Hue on 11/12/2016.
 */
@Service
public class FoodStoreService {

    @Autowired
    private FoodStoreRepository foodStoreRepository;

    @Autowired
    private StoreReponsitory storeReponsitory;

    @Autowired
    private FoodRepository foodRepository;

    public Iterable<FoodStore> findAll() {
        return foodStoreRepository.findAll();
    }

    /**
     * find food in store
     *
     * @param id
     * @return
     */
    public Iterable<FoodStore> findByStore(int id) {
        if (!foodStoreRepository.exists(id)) {
            throw new ExceptionForm("id", ExceptionForm.ERROR_CODE.EXIST, "is not exist");
        }
        return foodStoreRepository.findByStore(id);
    }


    public FoodStore save(int storeId, int foodId) {
        if (!storeReponsitory.exists(storeId)){
            throw new ExceptionForm("Store", ExceptionForm.ERROR_CODE.EXIST, "Store is not exist");
        }
        if(!foodRepository.exists(foodId)){
            throw new ExceptionForm("Food", ExceptionForm.ERROR_CODE.EXIST, "Food is not exist");
        }
        Store store = storeReponsitory.findOne(storeId);
        Food food = foodRepository.findOne(foodId);
        FoodStore foodStore = new FoodStore(store, food);
        return foodStoreRepository.save(foodStore);
    }

}

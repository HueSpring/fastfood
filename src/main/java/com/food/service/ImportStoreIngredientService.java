package com.food.service;

import com.food.common.Common;
import com.food.exception.ExceptionForm;
import com.food.model.ImportStoreIngredient;
import com.food.model.StoreIngredient;
import com.food.repository.ImportStoreIngredientRepository;
import com.food.repository.StoreIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Hue on 11/24/2016.
 */
@Service
public class ImportStoreIngredientService {

    public final Long DAY_MAX = 3L;

    @Autowired
    private ImportStoreIngredientRepository importStoreIngredientRepository;


    public Iterable<ImportStoreIngredient> findAll() {
        Iterable<ImportStoreIngredient> list = importStoreIngredientRepository.findAll();
        if (list == null) {
            throw new ExceptionForm("store ingredient", ExceptionForm.ERROR_CODE.EXIST, "Not found");
        }
        return list;
    }

    public Iterable<ImportStoreIngredient> findAllNearDate() {
        Date date = new Date();
        return importStoreIngredientRepository.findAllNearDate(Common.dateToString(date), Common.parseArrayInt(date, DAY_MAX));
    }

    public Iterable<ImportStoreIngredient> findAllNearQuantity(){
        return importStoreIngredientRepository.findAllNearQuantity();
    }

    public Iterable<ImportStoreIngredient> findAllUse(int storeId){
        Date date = new Date();
        return importStoreIngredientRepository.findAllUse(Common.dateToString(date), storeId);
    }

    public Iterable<ImportStoreIngredient> findAllEndDateNoQuantity(){
        Date date = new Date();
        return importStoreIngredientRepository.findAllEndDateNoQuantity(Common.dateToString(date));
    }

    public Iterable<ImportStoreIngredient> findAllEndQuantity(){
        return importStoreIngredientRepository.findAllEndQuantity();
    }

}

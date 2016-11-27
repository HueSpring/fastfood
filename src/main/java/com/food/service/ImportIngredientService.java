package com.food.service;

import com.food.common.Common;
import com.food.exception.ExceptionForm;
import com.food.model.Import;
import com.food.model.ImportIngredient;
import com.food.model.Ingredient;
import com.food.repository.ImportIngredientRepository;
import com.food.repository.ImportRepository;
import com.food.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

/**
 * Created by Hue on 11/14/2016.
 */
@Service
public class ImportIngredientService {

    public final Long DAY_MAX = 3L;

    @Autowired
    private ImportIngredientRepository importIngredientRepository;

    @Autowired
    private ImportRepository importRepository;

    @Autowired
    private IngredientRepository ingredientRepository;


    public Iterable<ImportIngredient> findAll() {
        Iterable<ImportIngredient> list = importIngredientRepository.findAll();
        if (list == null) {
            throw new ExceptionForm("import ingredient", ExceptionForm.ERROR_CODE.EXIST, "Not found");
        }
        return list;
    }

    public Iterable<ImportIngredient> findAllNearDate() {
        Date date = new Date();
        return importIngredientRepository.findAllNearDate(Common.dateToString(date), Common.parseArrayInt(date, DAY_MAX));
    }

    public Iterable<ImportIngredient> findAllNearQuantity(){
        return importIngredientRepository.findAllNearQuantity();
    }

    public Iterable<ImportIngredient> findAllUse(){
        Date date = new Date();
        return importIngredientRepository.findAllUse(Common.dateToString(date));
    }


    public Iterable<ImportIngredient> findAllEndDateNoQuantity(){
        Date date = new Date();
        return importIngredientRepository.findAllEndDateNoQuantity(Common.dateToString(date));
    }

    public Iterable<ImportIngredient> findAllEndQuantity(){
        return importIngredientRepository.findAllEndQuantity();
    }

    public ImportIngredient save(int quantity, int price, Date dateEnd, String unit, int ingredientId, int importId){
        if(!ingredientRepository.exists(ingredientId)){
            throw new ExceptionForm("Ingredient", ExceptionForm.ERROR_CODE.EXIST, "Ingredient is not exist");
        }
        if(!importRepository.exists(importId)){
            throw new ExceptionForm("Import", ExceptionForm.ERROR_CODE.EXIST, "Import is not exist");
        }
        Ingredient ingredient = ingredientRepository.findOne(ingredientId);
        Import importS = importRepository.findOne(importId);
        ImportIngredient importIngredient = new ImportIngredient(quantity, price, Common.dateToString(dateEnd), unit, ingredient, importS);
        return importIngredientRepository.save(importIngredient);
    }


    public ImportIngredient update(int id, int quantity, int price, Date dateEnd, String unit, int ingredientId, int importId){
        if(!importIngredientRepository.exists(id)){
            throw new ExceptionForm("Import ingredient", ExceptionForm.ERROR_CODE.EXIST, "Import ingredient is not exist");
        }
        if(!ingredientRepository.exists(ingredientId)){
            throw new ExceptionForm("Ingredient", ExceptionForm.ERROR_CODE.EXIST, "Ingredient is not exist");
        }
        if(!importRepository.exists(importId)){
            throw new ExceptionForm("Import", ExceptionForm.ERROR_CODE.EXIST, "Import is not exist");
        }
        ImportIngredient importIngredient = importIngredientRepository.findOne(id);
        importIngredient.setQuantity(quantity);
        importIngredient.setPrice(price);
        importIngredient.setDateEnd(Common.dateToString(dateEnd));
        importIngredient.setUnit(unit);
        Ingredient ingredient = ingredientRepository.findOne(ingredientId);
        Import importS = importRepository.findOne(importId);
        importIngredient.setIngredient(ingredient);
        importIngredient.setAnImport(importS);
        return importIngredientRepository.save(importIngredient);
    }


    public ResponseEntity delete(int id){
        if(importIngredientRepository.exists(id)){
            throw new ExceptionForm("Import ingredient", ExceptionForm.ERROR_CODE.EXIST, "Import ingredient is not exist");
        }
        importIngredientRepository.delete(id);
        return ResponseEntity.ok("Delete " + id + " successfully");
    }

}

package com.food.controller;

import com.food.model.ImportStoreIngredient;
import com.food.model.StoreIngredient;
import com.food.service.ImportStoreIngredientService;
import com.food.service.StoreIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Hue on 11/24/2016.
 */
@RestController
@RequestMapping(value = "/{key}/ingredient/import/store")
public class ImportStoreIngredientController {

    @Autowired
    private ImportStoreIngredientService importStoreIngredientService;

    @RequestMapping(value = "/day-near", method = RequestMethod.GET)
    public Iterable<ImportStoreIngredient> findAllNearDate(@PathVariable(value = "key") String key){
        return importStoreIngredientService.findAllNearDate();
    }

    @RequestMapping(value = "/quantity-near", method = RequestMethod.GET)
    public Iterable<ImportStoreIngredient> findAllNearQuantity(@PathVariable(value = "key") String key){
        return importStoreIngredientService.findAllNearQuantity();
    }

    @RequestMapping(value = "/{storeId}/use", method = RequestMethod.GET)
    public Iterable<ImportStoreIngredient> findAllUse(@PathVariable(value = "key") String key, @PathVariable(value = "storeId") int storeId){
        return importStoreIngredientService.findAllUse(storeId);
    }

    @RequestMapping(value = "/quantity-end", method = RequestMethod.GET)
    public Iterable<ImportStoreIngredient> findAllEndQuantity(@PathVariable(value = "key") String key){
        return importStoreIngredientService.findAllEndQuantity();
    }

    @RequestMapping(value = "/date-end", method = RequestMethod.GET)
    public Iterable<ImportStoreIngredient> findAllEndDateNoQuantity(@PathVariable(value = "key") String key){
        return importStoreIngredientService.findAllEndDateNoQuantity();
    }


}

package com.food.repository;

import com.food.model.ImportStoreIngredient;
import com.food.model.StoreIngredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Hue on 11/24/2016.
 */
public interface ImportStoreIngredientRepository extends CrudRepository<ImportStoreIngredient, Integer>{

    //sap het han
    @Query("SELECT isi FROM ImportStoreIngredient isi WHERE isi.dateEnd >= ?1 AND isi.dateEnd <= ?2")
    public Iterable<ImportStoreIngredient> findAllNearDate(String dateCurrent, String datePlus3);

    //sap het so luong
    @Query("SELECT isi FROM ImportStoreIngredient isi WHERE isi.quantity <= 20")
    public Iterable<ImportStoreIngredient> findAllNearQuantity();

    //con han, con so luong -> con su dung dc
    @Query("SELECT isi FROM ImportStoreIngredient isi JOIN isi.storeIngredient si JOIN si.store s WHERE isi.dateEnd >= ?1 AND isi.quantity > 0 AND s.id = ?2")
    public Iterable<ImportStoreIngredient> findAllUse(String dateCurrent, int storeId);

    //het han, chua het so luong
    @Query("SELECT isi FROM ImportStoreIngredient isi WHERE isi.dateEnd < ?1 AND isi.quantity < 0")
    public Iterable<ImportStoreIngredient> findAllEndDateNoQuantity(String dateCurrent);

    //het so luong
    @Query("SELECT isi FROM ImportStoreIngredient isi WHERE isi.quantity = 0")
    public Iterable<ImportStoreIngredient> findAllEndQuantity();

}

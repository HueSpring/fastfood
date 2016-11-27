
package com.food.repository;

import com.food.model.Store;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PreUpdate;

/**
 * Created by Hue on 10/31/2016.
 */
@Transactional
public interface StoreReponsitory extends CrudRepository<Store, Integer> {

    @Query("SELECT s FROM Store s WHERE s.noStreet = ?1 AND s.district = ?2")
    public Store getByAddress(String noStreet, String district);

    @Query("SELECT COUNT(u) FROM Store s JOIN s.users u WHERE s.id = ?1")
    public Long countEmp(int id);


    @Procedure("SP_DeleteStore")
    public void SP_DeleteStore(int id);

}

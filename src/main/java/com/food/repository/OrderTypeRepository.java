package com.food.repository;

import com.food.model.OrderType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Hue on 11/15/2016.
 */
@Transactional
public interface OrderTypeRepository extends CrudRepository<OrderType, Integer>{

    

}

package com.food.repository;

import com.food.model.Import;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Hue on 11/16/2016.
 */
@Transactional
public interface ImportRepository extends CrudRepository<Import, Integer>{



}

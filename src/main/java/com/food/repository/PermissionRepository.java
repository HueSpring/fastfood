package com.food.repository;

import com.food.model.Permission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Hue on 11/10/2016.
 */
public interface PermissionRepository extends CrudRepository<Permission, Integer> {

    @Transactional
    @Query("SELECT p FROM Permission p JOIN p.roles r WHERE r.id = ?1")
    public Iterable<Permission> findByRole(int roleId);
}

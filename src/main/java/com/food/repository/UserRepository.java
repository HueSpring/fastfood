package com.food.repository;

import com.food.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by Hue on 10/31/2016.
 */
@Transactional
public interface UserRepository extends CrudRepository<User, String>{

    @Query("SELECT u.email FROM User u WHERE u.email = ?1")
    public String getEmail(String email);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.active = 0")
    public Iterable<User> findDeactive();

    @Query("SELECT u FROM User u WHERE u.active = 1")
    public Iterable<User> findActive();

    @Query("SELECT u FROM User u JOIN u.store s WHERE s.id = ?1")
    public Iterable<User> findByStore(int id);

    @Query("SELECT u FROM User u WHERE u.keyCode = ?1")
    public User findByKey(String keyCode);


    @Query("SELECT u.id AS id, u.firstName AS firstName FROM User u")
    public Set<User> findUser();

}

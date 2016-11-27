package com.food.repository;

import com.food.model.Salary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Hue on 10/31/2016.
 */
@Transactional
public interface SalaryRepository extends CrudRepository<Salary, Integer> {

    @Query("SELECT s FROM Salary s JOIN s.user u JOIN u.store st WHERE ((s.month = ?1 AND s.year = ?2) OR st.id = ?3) AND s.status = 1")
    public Iterable<Salary> findMonthStore(int month, int year, int storeId);

    @Query("SELECT s FROM Salary s WHERE s.month = ?1 AND s.year = ?2 AND s.status = 1")
    public Iterable<Salary> findMonth(int month, int year);

    @Query("SELECT s FROM Salary s WHERE s.status = 1")
    public Iterable<Salary> findAllStatus();

    @Query("SELECT s FROM Salary s WHERE s.status = false")
    public Iterable<Salary> findAllNoStatus();

    @Query("SELECT s FROM Salary s JOIN s.user u JOIN u.store st WHERE st.id = ?1 AND s.status = 1")
    public Iterable<Salary> findStore(int id);

}

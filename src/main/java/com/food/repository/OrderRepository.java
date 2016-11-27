package com.food.repository;

import com.food.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Hue on 11/15/2016.
 */
@Transactional
public interface OrderRepository extends CrudRepository<Book, String> {

    @Query("SELECT o FROM Book o JOIN o.orderType ot WHERE o.status = ?1 AND ot.name = ?2")
    public Iterable<Book> findAllByStatus(int status, int typeName);

    @Query("SELECT o FROM Book o JOIN o.orderType ot WHERE (o.status = ?1 OR o.status = ?2) AND ot.name = ?3")
    public Iterable<Book> findAllBy2Status(int status1, int status2, int typeId);


    @Query("SELECT o FROM Book o JOIN o.orderType ot WHERE o.status = ?1 AND ot.name = ?2 AND o.dateOrder = ?3")
    public Iterable<Book> findAllByStatusTime(int status, int typeName, String dateOrder);

    @Query("SELECT o FROM Book o JOIN o.orderType ot WHERE (o.status = ?1 OR o.status = ?2) AND ot.name = ?3 AND o.dateOrder = ?4")
    public Iterable<Book> findAllBy2StatusTime(int status1, int status2, int typeName, String dateOrder);



}

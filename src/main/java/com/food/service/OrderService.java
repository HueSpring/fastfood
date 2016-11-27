package com.food.service;

import com.food.common.Common;
import com.food.exception.ExceptionForm;
import com.food.model.*;
import com.food.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Hue on 11/15/2016.
 */
@Service
public class OrderService {

    public final int STATUS_DEFAULT = 1;
    public final int TYPE_ONLINE = 1;
    public final int TYPE_OFFLINE = 2;


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderTypeRepository orderTypeRepository;

    public OrderService() {
    }

    public Iterable<Book> findAll() {
        Iterable<Book> list = orderRepository.findAll();
        if (list == null) {
            throw new ExceptionForm("Order", ExceptionForm.ERROR_CODE.EXIST, "Not found");
        }
        return list;
    }

    //online + status = 0 & status = 3
    public Iterable<Book> findAllOnlineNoUse(){
        return findAllBy2Status(0, 3, TYPE_ONLINE);
    }

    //online + status = 0 & status = 3 + day
    public Iterable<Book> findAllOnlineNoUseTime(Date date){
        return findAllBy2StatusTime(0, 3, TYPE_ONLINE, date);
    }

    //online + status = 1
    public Iterable<Book> findAllOnlineNoUse1(){
        return findAllByStatus(1, TYPE_ONLINE);
    }

    //online + status = 1 + day
    public Iterable<Book> findAllOnlineNoUseTime1(Date date){
        return findAllByStatusTime(1, TYPE_ONLINE, date);
    }

    //theo 1 trang thai + type order
    public Iterable<Book> findAllByStatus(int status, int typeName){
        Iterable<Book> list = orderRepository.findAllByStatus(status, typeName);
        if (list == null) {
            throw new ExceptionForm("Order", ExceptionForm.ERROR_CODE.EXIST, "Not found");
        }
        return list;
    }

    //theo 2 trang thai + type order
    public Iterable<Book> findAllBy2Status(int status1, int status2, int typeId){
        Iterable<Book> list = orderRepository.findAllBy2Status(status1, status2, typeId);
        if (list == null) {
            throw new ExceptionForm("Order", ExceptionForm.ERROR_CODE.EXIST, "Not found");
        }
        return list;
    }

    //theo 2 trang thai + type order + day
    public Iterable<Book> findAllBy2StatusTime(int status1, int status2, int typeName, Date date){
        String dateString = Common.dateToString(date);
        Iterable<Book> list = orderRepository.findAllBy2StatusTime(status1, status2, typeName, dateString);
        if (list == null) {
            throw new ExceptionForm("Order", ExceptionForm.ERROR_CODE.EXIST, "Not found");
        }
        return list;
    }

    //theo 1 trang thai + type order + day
    public Iterable<Book> findAllByStatusTime(int status, int typeName, Date date){
        String dateString = Common.dateToString(date);
        Iterable<Book> list = orderRepository.findAllByStatusTime(status, typeName, dateString);
        if (list == null) {
            throw new ExceptionForm("Order", ExceptionForm.ERROR_CODE.EXIST, "Not found");
        }
        return list;
    }


    public Book findOne(String id) {
        if (!orderRepository.exists(id)) {
            throw new ExceptionForm("Order", ExceptionForm.ERROR_CODE.EXIST, "Order is not exist");
        }
        return orderRepository.findOne(id);
    }


    public Book save(String idCustomer, String address, int orderTypeId) {
        if (orderRepository.exists(idCustomer)) {
            throw new ExceptionForm("Order", ExceptionForm.ERROR_CODE.EXIST, "Order is already exist");
        }
        OrderType orderType = orderTypeRepository.findOne(orderTypeId);
        Date date = new Date();
        String dateCreated = Common.dateTimeToString(date);
        String idOrder = Common.splitDateTime(date)  + orderRepository.count();
        Book order = new Book(idOrder, address, STATUS_DEFAULT, dateCreated, orderType);
        return orderRepository.save(order);
    }


    /**
     *
     * @param id
     * @param status
     * @return
     */
    public Book update(String id, int status){
        if (orderRepository.exists(id)) {
            throw new ExceptionForm("Order", ExceptionForm.ERROR_CODE.EXIST, "Order is already exist");
        }
        Book order = orderRepository.findOne(id);
        Date date = new Date();
        String dateBill = Common.dateTimeToString(date);
        order.setDateOrder(dateBill);
        order.setStatus(status);
        return orderRepository.save(order);
    }


    public ResponseEntity<String> delete(String id) {
        if (!orderRepository.exists(id)) {
            throw new ExceptionForm("order", ExceptionForm.ERROR_CODE.EXIST, "Order is not exist");
        }
        orderRepository.delete(id);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }


}

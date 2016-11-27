package com.food.service;

import com.food.exception.ExceptionForm;
import com.food.model.Store;
import com.food.model.User;
import com.food.repository.StoreReponsitory;
import com.food.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by Hue on 10/31/2016.
 */
@Service
public class StoreService {

    @Autowired
    private StoreReponsitory storeReponsitory;

    @Autowired
    private UserRepository userRepository;

    public Store save(String name, String noStreet, String district) {
        if (storeReponsitory.getByAddress(noStreet, district) != null) {
            throw new ExceptionForm("address", ExceptionForm.ERROR_CODE.EXIST, "store is already exist");
        }
        Store store = new Store(name, noStreet, district);
        return storeReponsitory.save(store);
    }

    public Store update(int id, String name, String noStreet, String district) {
        if (storeReponsitory.getByAddress(noStreet, district) != null) {
            throw new ExceptionForm("address", ExceptionForm.ERROR_CODE.EXIST, "store is already exist");
        }
        Store store = storeReponsitory.findOne(id);
        store.setName(name);
        store.setNoStreet(noStreet);
        store.setDistrict(district);
        return storeReponsitory.save(store);
    }

    public Iterable<Store> findAll() {
        Iterable<Store> list = storeReponsitory.findAll();
        if(list == null){
            throw new ExceptionForm("store", ExceptionForm.ERROR_CODE.EXIST, "Not found");
        }
        return list;
    }

    public Store findOne(int id) {
        if (!storeReponsitory.exists(id)) {
            throw new ExceptionForm("id", ExceptionForm.ERROR_CODE.EXIST, "store is not exist");
        }
        return storeReponsitory.findOne(id);
    }

    public ResponseEntity delete(int id) {
        if (!storeReponsitory.exists(id)) {
            throw new ExceptionForm("id", ExceptionForm.ERROR_CODE.EXIST, "store is not exist");
        }
        storeReponsitory.SP_DeleteStore(id);
        return new ResponseEntity("success", HttpStatus.OK);
    }

    public Long countEmp(int id){
        return storeReponsitory.countEmp(id);
    }




}

package com.food.service;

import com.food.common.Common;
import com.food.exception.ExceptionForm;
import com.food.model.ImportStore;
import com.food.model.User;
import com.food.repository.ImportStoreRepository;
import com.food.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Hue on 11/25/2016.
 */
@Service
public class ImportStoreService {

    @Autowired
    private ImportStoreRepository importStoreRepository;

    @Autowired
    private UserRepository userRepository;

    public ImportStore save(String id1, String id2){
        if(!userRepository.exists(id1)){
            throw new ExceptionForm("User 1", ExceptionForm.ERROR_CODE.EXIST, "User, export ingredient is not exist");
        }
        if(!userRepository.exists(id2)){
            throw new ExceptionForm("User 2", ExceptionForm.ERROR_CODE.EXIST, "User, import ingredient is not exist");
        }
        User user1 = userRepository.findOne(id1);
        User user2 = userRepository.findOne(id2);
        Date date = new Date();
        ImportStore importStore = new ImportStore(Common.dateToString(date), user1, user2);
        return importStoreRepository.save(importStore);
    }

    public ResponseEntity delete(int id){
        if(!importStoreRepository.exists(id)){
            throw new ExceptionForm("Import store", ExceptionForm.ERROR_CODE.EXIST, "Import store is not exist");
        }
        importStoreRepository.delete(id);
        return ResponseEntity.ok("Delete " + id + " successfully");
    }

    public ImportStore updatePay(int id, boolean status){
        if(!importStoreRepository.exists(id)){
            throw new ExceptionForm("Import store", ExceptionForm.ERROR_CODE.EXIST, "Import store is not exist");
        }
        ImportStore importStore = importStoreRepository.findOne(id);
        importStore.setStatus(status);
        return importStoreRepository.save(importStore);
    }
}

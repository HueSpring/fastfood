package com.food.service;

import com.food.common.Common;
import com.food.exception.ExceptionForm;
import com.food.model.Import;
import com.food.model.User;
import com.food.repository.ImportRepository;
import com.food.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Hue on 11/16/2016.
 */
@Service
public class ImportService {

    @Autowired
    private ImportRepository importRepository;

    @Autowired
    private UserRepository userRepository;

    public Iterable<Import> findAll(){
        return importRepository.findAll();
    }


    public Import findOne(int id){
        if(!importRepository.exists(id)){
            throw new ExceptionForm("import", ExceptionForm.ERROR_CODE.EXIST, "Import is not found");
        }
        return importRepository.findOne(id);
    }

    public Import save(String id){
        Date date = new Date();
        if(!userRepository.exists(id)){
            throw new ExceptionForm("User", ExceptionForm.ERROR_CODE.EXIST, "User is not exist");
        }
        User user = userRepository.findOne(id);
        Import importS = new Import(Common.dateTimeToString(date), user);
        return importRepository.save(importS);
    }

    public ResponseEntity delete(int id){
        if(!importRepository.exists(id)){
            throw new ExceptionForm("User", ExceptionForm.ERROR_CODE.EXIST, "User is not exist");
        }
        importRepository.delete(id);
        return ResponseEntity.ok("success");
    }

    public Import updatePay(int id, boolean status){
        if(!importRepository.exists(id)){
            throw new ExceptionForm("User", ExceptionForm.ERROR_CODE.EXIST, "User is not exist");
        }
        Import imports = importRepository.findOne(id);
        imports.setStatus(status);
        return importRepository.save(imports);
    }

}

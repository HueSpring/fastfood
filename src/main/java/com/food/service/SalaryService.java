package com.food.service;


import com.food.exception.ExceptionForm;
import com.food.model.Salary;
import com.food.repository.SalaryRepository;
import com.food.repository.StoreReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Hue on 10/31/2016.
 */
@Service
public class SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;


    @Autowired
    private StoreReponsitory storeReponsitory;

    public Iterable<Salary> findAll() {
        Iterable<Salary> list = salaryRepository.findAll();
        if (list == null) {
            throw new ExceptionForm("salary", ExceptionForm.ERROR_CODE.EXIST, "Not found");
        }
        return list;
    }

    public Iterable<Salary> findAllStatus() {
        Iterable<Salary> list = salaryRepository.findAllStatus();
        if (list == null) {
            throw new ExceptionForm("salary", ExceptionForm.ERROR_CODE.EXIST, "Not found");
        }
        return list;
    }

    public Iterable<Salary> findAllNoStatus() {
        Iterable<Salary> list = salaryRepository.findAllNoStatus();
        if (list == null) {
            throw new ExceptionForm("salary", ExceptionForm.ERROR_CODE.EXIST, "Not found");
        }
        return list;
    }

    public Iterable<Salary> findMonthStore(int month, int year, int storeId) {
//        if(!storeReponsitory.exists(storeId)){
//            throw new ExceptionForm("Store", ExceptionForm.ERROR_CODE.EXIST, "Store is not exist");
//        }
        Iterable<Salary> list = null;
        if (month == 0 && year == 0 && storeId == 0) {
            list = salaryRepository.findAllStatus();
        } else if (storeId == 0 && (month != 0 && year != 0)) {
            list = salaryRepository.findMonth(month, year);
        } else if (month == 0 && year == 0 && storeId != 0) {
            list = salaryRepository.findStore(storeId);
        } else {
            list = salaryRepository.findMonthStore(month, year, storeId);
            if (list == null) {
                throw new ExceptionForm("Salary", ExceptionForm.ERROR_CODE.EXIST, "Not found");
            }
        }
        return list;
    }

}

package com.food.service;

import com.food.exception.ExceptionForm;
import com.food.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by Hue on 11/12/2016.
 */
@Service
public class AccountService {

    public static String ADMIN = "admin";
    public static String ACCOUNTANT = "accountant";
    public static String STORE_KEEPER = "storekeeper";
    public static String MANAGER = "manager";
    public static String MANAGER_MASTER = "manager master";


    public boolean ensureAdmin(User user) {
        if (ADMIN.equalsIgnoreCase(user.getRole().getName())) {
            return true;
        }
        return false;
    }


    public boolean ensureAccountant(User user) {
        if (ACCOUNTANT.equalsIgnoreCase(user.getRole().getName())) {
            return true;
        }
        return false;
    }

    public boolean ensureStoreKeeper(User user) {
        if (STORE_KEEPER.equalsIgnoreCase(user.getRole().getName())) {
            return true;
        }
        return false;
    }

    public boolean ensureManager(User user) {
        if (MANAGER.equalsIgnoreCase(user.getRole().getName())) {
            return true;
        }
        return false;
    }

    public boolean ensureManagerMaster(User user) {
        if (MANAGER_MASTER.equalsIgnoreCase(user.getRole().getName())) {
            return true;
        }
        return false;
    }
}

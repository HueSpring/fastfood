package com.food.service;

import com.food.common.Common;
import com.food.exception.ExceptionForm;
import com.food.model.Role;
import com.food.model.Store;
import com.food.model.User;
import com.food.repository.RoleReponsitory;
import com.food.repository.StoreReponsitory;
import com.food.repository.UserRepository;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

/**
 * Created by Hue on 10/31/2016.
 */
@Service
public class UserService {

    public final String PASS = "123456";

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private RoleReponsitory roleReponsitory;

    @Autowired
    private StoreReponsitory storeReponsitory;

    public User login(String id, String password) {
        if (!userRepository.exists(id)) {
            throw new ExceptionForm("Username", ExceptionForm.ERROR_CODE.EXIST, "Username is not exist");
        }
        User user = userRepository.findOne(id);
        System.out.println("PASS " + user.toString());
        if (!user.getPwd().equals(password)) {
            throw new ExceptionForm("Password", ExceptionForm.ERROR_CODE.INCORRECT, "Password is incorrect");
        }
        return user;
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(String id) {
        if (!userRepository.exists(id)) {
            throw new ExceptionForm("Username", ExceptionForm.ERROR_CODE.EXIST, "Username is not exist");
        }
        return userRepository.findOne(id);
    }

    public User save(String id, String firstName, String lastName, Date dob, String address,
                     String phone, String email, int storeId, int roleId) {
        if (userRepository.exists(id)) {
            throw new ExceptionForm("Username", ExceptionForm.ERROR_CODE.EXIST, "Username is already exist");
        }
        if (userRepository.getEmail(email) != null) {
            throw new ExceptionForm("Email", ExceptionForm.ERROR_CODE.EXIST, "Email is already exist");
        }
        if (!roleReponsitory.exists(roleId)) {
            throw new ExceptionForm("Role", ExceptionForm.ERROR_CODE.EXIST, "Role is already exist");
        }
        if (!storeReponsitory.exists(storeId)) {
            throw new ExceptionForm("Store", ExceptionForm.ERROR_CODE.EXIST, "Store is already exist");
        }
        String keyCode = Common.encryptMD5(id + Common.randomString());
        Date date = new Date();
        String dateCreated = Common.dateTimeToString(date);
        String dobString = Common.dateToString(dob);
        Role role = roleReponsitory.findOne(roleId);
        Store store = storeReponsitory.findOne(storeId);
        User user = new User(id, PASS, firstName, lastName, dobString, address, phone, email, true, dateCreated, keyCode, role, store);
        return userRepository.save(user);
    }

    public User update(String key, String id, String firstName, String lastName, Date dob, String address,
                       String phone, String email, int storeId, int roleId) {
        if (!userRepository.exists(id)) {
            throw new ExceptionForm("Username", ExceptionForm.ERROR_CODE.EXIST, "Username is already exist");
        }
        if (!roleReponsitory.exists(roleId)) {
            throw new ExceptionForm("Role", ExceptionForm.ERROR_CODE.EXIST, "Role is already exist");
        }
        if (!storeReponsitory.exists(storeId)) {
            throw new ExceptionForm("Store", ExceptionForm.ERROR_CODE.EXIST, "Store is already exist");
        }
        String emailE = userRepository.getEmail(email);
        User user = findOne(id);
        if (emailE != null && !user.getEmail().equals(emailE)) {
            throw new ExceptionForm("Email", ExceptionForm.ERROR_CODE.EXIST, "Email is already used");
        }
        if (user.getKeyCode().equals(key)) {
            throw new ExceptionForm("Update", ExceptionForm.ERROR_CODE.INVALID, "User can not update here");
        }
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAddress(address);
        user.setPhone(phone);
        user.setDob(Common.dateToString(dob));
        user.setEmail(email);
        Store store = storeReponsitory.findOne(storeId);
        user.setStore(store);
        Role role = roleReponsitory.findOne(roleId);
        user.setRole(role);
        return userRepository.save(user);
    }


    public User updateOwner(String key, String id, String firstName, String lastName, Date dob, String address,
                            String phone, String email) {
        if (!userRepository.exists(id)) {
            throw new ExceptionForm("Username", ExceptionForm.ERROR_CODE.EXIST, "Username is already exist");
        }
        User user = findOne(id);
        if (!user.getKeyCode().equals(key)) {
            throw new ExceptionForm("Update", ExceptionForm.ERROR_CODE.INVALID, "User can not update here");
        }
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAddress(address);
        user.setPhone(phone);
        user.setDob(Common.dateToString(dob));
        user.setEmail(email);
        return userRepository.save(user);
    }


    public User findByKey(String key) {
        User user = userRepository.findByKey(key);
        if (user == null) {
            throw new ExceptionForm("Key Code", ExceptionForm.ERROR_CODE.EXIST, "Key code is not exist");
        }
        return user;
    }

    public User updatePass(String keyCode, String passOld, String passNew, String passRep) {
        User user = userRepository.findByKey(keyCode);
        if (!user.getPwd().equals(passOld)) {
            throw new ExceptionForm("Password old", ExceptionForm.ERROR_CODE.INCORRECT, "Old password is incorrect");
        }
        if (!passNew.equals(passRep)) {
            throw new ExceptionForm("Password repeat", ExceptionForm.ERROR_CODE.INCORRECT, "Repeat password is incorrect");
        }
        user.setPwd(passNew);
        return userRepository.save(user);

    }

    public ResponseEntity delete(String id) {
        if (!userRepository.exists(id)) {
            throw new ExceptionForm("Username", ExceptionForm.ERROR_CODE.EXIST, "Username is already exist");
        }
        userRepository.delete(id);
        return ResponseEntity.ok("Success");
    }


    public User updateDe(String id) {
        if (!userRepository.exists(id)) {
            throw new ExceptionForm("Username", ExceptionForm.ERROR_CODE.EXIST, "Username is already exist");
        }
        User user = userRepository.findOne(id);
        user.setActive(false);
        userRepository.save(user);
        return user;
    }

    public User updateActive(String id) {
        if (!userRepository.exists(id)) {
            throw new ExceptionForm("Username", ExceptionForm.ERROR_CODE.EXIST, "Username is already exist");
        }
        User user = userRepository.findOne(id);
        user.setActive(true);
        userRepository.save(user);
        return user;
    }

    public User addStore(String id, int storeId) {
        if (!userRepository.exists(id)) {
            throw new ExceptionForm("Username", ExceptionForm.ERROR_CODE.EXIST, "Username is already exist");
        }
        if (!storeReponsitory.exists(storeId)) {
            throw new ExceptionForm("Store", ExceptionForm.ERROR_CODE.EXIST, "Store is already exist");
        }
        User user = userRepository.findOne(id);
        Store store = storeReponsitory.findOne(storeId);
        user.setStore(store);
        return userRepository.save(user);
    }

    public Iterable<User> findDeactive() {
        return userRepository.findDeactive();
    }


    public Iterable<User> findActive() {
        return userRepository.findActive();
    }

    public String getEmail(String email) {
        return userRepository.getEmail(email);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
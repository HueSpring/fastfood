package com.food.service;

import com.food.exception.ExceptionForm;
import com.food.model.Permission;
import com.food.model.User;
import com.food.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Hue on 11/10/2016.
 */
@Service
public class PermissionService {

    public static final String USER_ADD = "User-Add";
    public static final String USER_UPDATE = "User-Update";
    public static final String USER_DELETE = "User-Delete";
    public static final String USER_VIEW = "User-View";
    public static final String STORE_ADD = "Store-Add";
    public static final String STORE_UPDATE = "Store-Update";
    public static final String STORE_DELETE = "Store-Delete";
    public static final String STORE_VIEW = "Store-View";
    public static final String INGREDIENT_ADD = "Ingredient-Add";
    public static final String INGREDIENT_UPDATE = "Ingredient-Update";
    public static final String INGREDIENT_DELETE = "Ingredient-Delete";
    public static final String INGREDIENT_VIEW = "Ingredient-View";
    public static final String FOOD_ADD = "Food-Add";
    public static final String FOOD_UPDATE = "Food-Update";
    public static final String FOOD_DELETE = "Food-Delete";
    public static final String FOOD_VIEW = "Food-View";
    public static final String ORDER_ADD = "Order-Add";
    public static final String ORDER_UPDATE = "Order-Update";
    public static final String ORDER_DELETE = "Order-Delete";
    public static final String ORDER_VIEW = "Order-View";
    public static final String SALARY_ADD = "Salary-Add";
    public static final String SALARY_UPDATE = "Salary-Update";
    public static final String SALARY_DELETE = "Salary-Delete";
    public static final String SALARY_VIEW = "Salary-View";
    public static final String CUSTOMER_ADD = "Customer-Add";
    public static final String CUSTOMER_UPDATE = "Customer-Update";
    public static final String CUSTOMER_DELETE = "Customer-Delete";
    public static final String CUSTOMER_VIEW = "Customer-View";
    public static final String IMPORT_EXPORT_ADD = "Import-Export-Add";
    public static final String IMPORT_EXPORT_UPDATE = "Import-Export-Update";
    public static final String IMPORT_EXPORT_DELETE = "Import-Export-Delete";
    public static final String IMPORT_EXPORT_VIEW = "Import-Export-View";
    public static final String IMPORT_ADD = "Import-Add";
    public static final String IMPORT_UPDATE = "Import-Update";
    public static final String IMPORT_DELETE = "Import-Delete";
    public static final String IMPORT_VIEW = "Import-View";
    @Autowired
    private UserService userService;

    @Autowired
    private PermissionRepository permissionRepository;

    public Iterable<Permission> findByRole(User user) {
        return permissionRepository.findByRole(user.getRole().getId());
    }

    public void permission(String permis, String key){
        if(key == null){
            throw new ExceptionForm("account", ExceptionForm.ERROR_CODE.INVALID, "Account is incorrect");
        }
        User user = userService.findByKey(key);
        Iterable<Permission> list = findByRole(user);
        for (Permission permission: list) {
            if(permis.equalsIgnoreCase(permission.getName())){
                return;
            }
        }
        throw new ExceptionForm("Permission", ExceptionForm.ERROR_CODE.INVALID, "You be not allowed");
    }


}

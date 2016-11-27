package com.food.exception;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hue on 10/31/2016.
 */
public class ExceptionForm extends RuntimeException{

    private List<Error> errors = new ArrayList<>();

    public ExceptionForm() {
    }

    public ExceptionForm(BindingResult bindingResult) {
        List<FieldError> list_errors = bindingResult.getFieldErrors();

        for (FieldError i_error : list_errors) {
            Error error = new Error();
            error.setName(i_error.getField());
            error.setCode(ERROR_CODE.INVALID);
            error.setMessage(i_error.getDefaultMessage());
            errors.add(error);
        }
    }

    public ExceptionForm(String name, ERROR_CODE errorCode, String message){
        Error error = new Error();
        error.setName(name);
        error.setCode(errorCode);
        error.setMessage(message);
        errors.add(error);
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }






    /**
     * name of errors
     */
    public enum ERROR_CODE {
        INVALID,
        EXIST,
        INCORRECT
    }

    public static class Error {
        String name;
        ERROR_CODE code;
        String message;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ERROR_CODE getCode() {
            return code;
        }

        public void setCode(ERROR_CODE code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}

package com.example.dto;

import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class ErrorDto {

    private final int status;
    private final String message;
    private List<FieldError> fieldErrors = new ArrayList<>();

    private ErrorDto(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public static ErrorDto of(int status, String message) {
        return new ErrorDto(status, message);
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void addFieldError(String objectName, String path, String message) {
        FieldError error = new FieldError(objectName, path, message);
        fieldErrors.add(error);
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }
}


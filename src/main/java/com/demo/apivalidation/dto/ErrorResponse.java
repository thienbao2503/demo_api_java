package com.demo.apivalidation.dto;

import java.util.List;

public class ErrorResponse {

    private int status;
    private String message;
    private List<FieldError> errors;

    public ErrorResponse(int status, String message, List<FieldError> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<FieldError> getErrors() {
        return errors;
    }
}
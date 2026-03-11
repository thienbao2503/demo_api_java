package com.demo.apivalidation.dto;

import java.util.List;

public class ApiResponse {

    private int status;
    private String message;
    private List<FieldErrorResponse> errors;

    public ApiResponse() {
    }

    public ApiResponse(int status, String message, List<FieldErrorResponse> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FieldErrorResponse> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldErrorResponse> errors) {
        this.errors = errors;
    }
}
package com.demo.apivalidation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StrongPasswordValidator implements ConstraintValidator<StrongPassword, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {

        if (password == null || password.isEmpty()) {
            return true; // để NotBlank xử lý
        }

        context.disableDefaultConstraintViolation();

        if (password.length() < 8) {
            context.buildConstraintViolationWithTemplate("Password phải >= 8 ký tự")
                    .addConstraintViolation();
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            context.buildConstraintViolationWithTemplate("Password phải chứa ít nhất 1 chữ hoa")
                    .addConstraintViolation();
            return false;
        }

        if (!password.matches(".*[a-z].*")) {
            context.buildConstraintViolationWithTemplate("Password phải chứa ít nhất 1 chữ thường")
                    .addConstraintViolation();
            return false;
        }

        if (!password.matches(".*[0-9].*")) {
            context.buildConstraintViolationWithTemplate("Password phải chứa ít nhất 1 số")
                    .addConstraintViolation();
            return false;
        }

        if (!password.matches(".*[@#$%^&+=!].*")) {
            context.buildConstraintViolationWithTemplate("Password phải chứa ít nhất 1 ký tự đặc biệt")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
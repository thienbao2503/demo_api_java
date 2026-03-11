package com.demo.apivalidation.exception;

import com.demo.apivalidation.dto.ApiResponse;
import com.demo.apivalidation.dto.FieldErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

        // Validation error
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ApiResponse> handleValidation(MethodArgumentNotValidException ex) {

                List<FieldErrorResponse> errors = ex.getBindingResult()
                                .getFieldErrors()
                                .stream()
                                .map(err -> new FieldErrorResponse(
                                                err.getField(),
                                                err.getDefaultMessage()))
                                .collect(Collectors.toList());

                ApiResponse response = new ApiResponse(
                                400,
                                "Validation failed",
                                errors);

                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        // Business error (DB check)
        @ExceptionHandler(BusinessException.class)
        public ResponseEntity<ApiResponse> handleBusiness(BusinessException ex) {

                List<FieldErrorResponse> errors = List.of(
                                new FieldErrorResponse(ex.getField(), ex.getMessage()));

                ApiResponse response = new ApiResponse(
                                400,
                                "Business error",
                                errors);

                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
}
package com.demo.apivalidation.controller;

import com.demo.apivalidation.dto.LoginRequest;
import com.demo.apivalidation.dto.RegisterRequest;
import com.demo.apivalidation.dto.ApiResponse;
import com.demo.apivalidation.service.AuthService;

import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // @Valid là điểm kích hoạt validation.
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {
        authService.register(request);

        ApiResponse response = new ApiResponse(
                200,
                "Register success",
                List.of());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        authService.login(request);
        ApiResponse response = new ApiResponse(
                200,
                "Login success",
                List.of());

        return ResponseEntity.ok(response);
    }
}
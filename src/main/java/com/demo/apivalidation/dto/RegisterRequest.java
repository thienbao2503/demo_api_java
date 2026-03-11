package com.demo.apivalidation.dto;

import lombok.Data;
import jakarta.validation.constraints.*;
import com.demo.apivalidation.validation.StrongPassword;

@Data
public class RegisterRequest {
    // DTO dùng Jakarta Bean Validation. (Annotation)
    @NotBlank(message = "Username không được để trống")
    @Size(min = 4, max = 20, message = "Username phải từ 4-20 ký tự")
    private String username;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    private String email;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^(0[3|5|7|8|9])[0-9]{8}$", message = "Số điện thoại không hợp lệ")
    private String phone;

    @NotBlank(message = "Password không được để trống")
    @StrongPassword
    private String password;
}
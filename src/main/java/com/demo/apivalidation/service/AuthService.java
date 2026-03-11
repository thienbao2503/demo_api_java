package com.demo.apivalidation.service;

import com.demo.apivalidation.dto.LoginRequest;
import com.demo.apivalidation.dto.RegisterRequest;
import com.demo.apivalidation.entity.User;
import com.demo.apivalidation.repository.UserRepository;
import com.demo.apivalidation.exception.BusinessException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(RegisterRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new BusinessException("username", "Username đã tồn tại");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BusinessException("email", "Email đã tồn tại");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(request.getPassword());

        userRepository.save(user);
    }

    public void login(LoginRequest request) {

        User user = userRepository
                .findByUsername(request.getUsername())
                .orElseThrow(() -> new BusinessException("username", "User không tồn tại"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new BusinessException("password", "Sai mật khẩu");
        }
    }
}
package com.mdv.appstore.controller;

import com.mdv.appstore.model.dto.LoginDTO;
import com.mdv.appstore.model.request.UserLoginRequest;
import com.mdv.appstore.model.request.UserRegisterRequest;
import com.mdv.appstore.model.response.ApiResponse;
import com.mdv.appstore.service.AuthService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${app.api.base-url}/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ApiResponse<LoginDTO> login(@RequestBody UserLoginRequest user) {
        return ApiResponse.success(authService.login(user), "Login successful");
    }

    @PostMapping("/register")
    public ApiResponse<Void> register(@RequestBody UserRegisterRequest user) {
        authService.register(user);
        return ApiResponse.success("Registration successful");
    }

    @PostMapping("/logout")
    public ApiResponse<Void> logout(
            @RequestHeader("Authorization") String authHeader,
            @RequestBody(required = false) Map<String, String> body) {
        String token = authHeader.substring(7);
        authService.logout(token, body);
        return ApiResponse.success("Logout successful");
    }
}

package com.zhassurbek.mixproject.controller;

import com.zhassurbek.mixproject.dao.request.SignInRequestDto;
import com.zhassurbek.mixproject.dao.request.SignUpRequestDto;
import com.zhassurbek.mixproject.dao.response.JwtAuthenticationResponseDto;
import com.zhassurbek.mixproject.service.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponseDto> signup(@RequestBody SignUpRequestDto signUpRequestDto) {
        return ResponseEntity.ok(authenticationService.signup(signUpRequestDto));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponseDto> signin(@RequestBody SignInRequestDto signInRequestDto) {
        return ResponseEntity.ok(authenticationService.signin(signInRequestDto));
    }

}

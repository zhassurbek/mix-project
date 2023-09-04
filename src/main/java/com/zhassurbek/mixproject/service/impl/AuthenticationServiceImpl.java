package com.zhassurbek.mixproject.service.impl;

import com.zhassurbek.mixproject.dao.request.SignInRequestDto;
import com.zhassurbek.mixproject.dao.request.SignUpRequestDto;
import com.zhassurbek.mixproject.dao.response.JwtAuthenticationResponseDto;
import com.zhassurbek.mixproject.jpaRepo.UserRepository;
import com.zhassurbek.mixproject.model.Role;
import com.zhassurbek.mixproject.model.User;
import com.zhassurbek.mixproject.service.security.AuthenticationService;
import com.zhassurbek.mixproject.service.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public JwtAuthenticationResponseDto signup(SignUpRequestDto request) {
        var user = User.builder().name(request.getName()).surname(request.getSurname())
                .username(request.getUsername()).password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponseDto.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponseDto signin(SignInRequestDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepository.findByUsername(request.getUsername());
//                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponseDto.builder().token(jwt).build();
    }
}
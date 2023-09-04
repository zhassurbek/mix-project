package com.zhassurbek.mixproject.service.security;

import com.zhassurbek.mixproject.dao.request.SignInRequestDto;
import com.zhassurbek.mixproject.dao.request.SignUpRequestDto;
import com.zhassurbek.mixproject.dao.response.JwtAuthenticationResponseDto;

public interface AuthenticationService {

    JwtAuthenticationResponseDto signin(SignInRequestDto signInRequestDto);

    JwtAuthenticationResponseDto signup(SignUpRequestDto signUpRequestDto);

}

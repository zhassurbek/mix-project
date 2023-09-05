package com.zhassurbek.mixproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/resource")
@RequiredArgsConstructor
public class AuthorizationController {

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return new ResponseEntity<>("Say Hello", HttpStatus.NOT_FOUND);
    }



}

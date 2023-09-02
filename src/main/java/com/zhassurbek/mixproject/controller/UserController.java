package com.zhassurbek.mixproject.controller;

import com.zhassurbek.mixproject.MixProjectApplication;
import com.zhassurbek.mixproject.dto.response.ErrorCreateUserResponseDto;
import com.zhassurbek.mixproject.model.User;
import com.zhassurbek.mixproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequestMapping("/mix-spring")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final Logger logger = LoggerFactory.getLogger(MixProjectApplication.class);

    @GetMapping("/user/{username}")
    public ResponseEntity<?> findByUsername(@PathVariable  String username) {
        try {
            logger.info("User with " + username + " get");
            User user = userService.findByUsername(username);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody User user) {
       try {
           return userService.createUser(user);
       } catch (Exception e) {
           // Обработка ошибки и возврат объекта ErrorResponse
           String errorMessage = "Такой юзернейм уже существует. Наберите другой юзернейм.";
           ErrorCreateUserResponseDto errorCreateUserResponseDto = new ErrorCreateUserResponseDto(errorMessage);
           return new ResponseEntity<>(errorCreateUserResponseDto, HttpStatus.BAD_REQUEST);
       }
        }

}

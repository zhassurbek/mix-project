package com.zhassurbek.mixproject.controller;

import com.zhassurbek.mixproject.MixProjectApplication;
import com.zhassurbek.mixproject.dto.response.ErrorUserResponseDto;
import com.zhassurbek.mixproject.model.User;
import com.zhassurbek.mixproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mix-spring/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final Logger logger = LoggerFactory.getLogger(MixProjectApplication.class);

    @GetMapping("/user/{username}")
    public ResponseEntity<?> findByUsername(@PathVariable String username) {
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
            ErrorUserResponseDto errorCreateUserResponseDto = new ErrorUserResponseDto(errorMessage);
            return new ResponseEntity<>(errorCreateUserResponseDto, HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/delete/user/{id}")
    public ResponseEntity<?> deleteUserByUsername(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            String errorMessage = "Не удалось удалить юзера";
            ErrorUserResponseDto errorUserResponseDto = new ErrorUserResponseDto(errorMessage);
            return new ResponseEntity<>(errorUserResponseDto, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{username}")
    public void deleteByUsername(@PathVariable String username) {
        userService.deleteByUsername(username);
    }


    @PutMapping("/update/user/{username}")
    public ResponseEntity<?> updateUserByUsername(@RequestBody User user, @PathVariable String username) {
        try {
            User forUpdataUser = userService.updateUserByUsername(user, username);
            return new ResponseEntity<>(forUpdataUser, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            String errorMessage = "Не удалось обновить пользователя: " + username;
            ErrorUserResponseDto errorUserResponseDto = new ErrorUserResponseDto(errorMessage);
            return new ResponseEntity<>(errorUserResponseDto, HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        try {
            List<User> users =  userService.getAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

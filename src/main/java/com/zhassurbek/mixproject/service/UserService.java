package com.zhassurbek.mixproject.service;

import com.zhassurbek.mixproject.MixProjectApplication;
import com.zhassurbek.mixproject.jpaRepo.UserRepository;
import com.zhassurbek.mixproject.model.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(MixProjectApplication.class);

    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    public ResponseEntity<User> createUser(User user) {
        logger.info("Вызвано метод по созданию юзера(username): " + user.getUsername());
        userRepository.save(user);
        logger.info("Id: " + user.getId() + ", name: " + user.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

    public User updateUserByUsername(User user, String username) {
//        String currentUsername = username;
        User beforeUpdateUser = userRepository.findByUsername(username);
        if (user.getName() != null) {
            beforeUpdateUser.setName(user.getName());
        } else if (user.getSurname() != null) {
            beforeUpdateUser.setSurname(user.getSurname());
        } else if (user.getEmail() != null) {
            beforeUpdateUser.setEmail(user.getEmail());
        } else if (user.getPassword() != null) {
            beforeUpdateUser.setPassword(user.getPassword());
        }


        userRepository.save(beforeUpdateUser);
        return beforeUpdateUser;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}

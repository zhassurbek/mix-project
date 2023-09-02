package com.zhassurbek.mixproject.service;

import com.zhassurbek.mixproject.MixProjectApplication;
import com.zhassurbek.mixproject.jpaRepo.UserRepository;
import com.zhassurbek.mixproject.model.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

}

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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@Service
public interface UserService {

    UserDetailsService userDetailsService();

    User findByUsername(String username);

    ResponseEntity<User> createUser(User user);

    void deleteUser(Long id);

    void deleteByUsername(String username);
    User updateUserByUsername(User user, String username);
    List<User> getAllUsers();

}

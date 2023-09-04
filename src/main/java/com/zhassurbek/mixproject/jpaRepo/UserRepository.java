package com.zhassurbek.mixproject.jpaRepo;

import java.util.Optional;


import com.zhassurbek.mixproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    // Since email is unique, we'll find users by email
    Optional<User> findByEmail(String email);

    void deleteByUsername(String username);


}

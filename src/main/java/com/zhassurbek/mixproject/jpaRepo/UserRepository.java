package com.zhassurbek.mixproject.jpaRepo;

import com.zhassurbek.mixproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);

    void deleteByUsername(String username);


}

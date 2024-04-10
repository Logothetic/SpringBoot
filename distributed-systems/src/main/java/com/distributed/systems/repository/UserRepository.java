package com.distributed.systems.repository;

import com.distributed.systems.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String email);
}

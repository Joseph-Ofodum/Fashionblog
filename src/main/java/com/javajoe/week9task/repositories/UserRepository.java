package com.javajoe.week9task.repositories;

import com.javajoe.week9task.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
}

package com.javajoe.week9task.repositories;

import com.javajoe.week9task.entities.UserModel;
import com.javajoe.week9task.enums.Role;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    UserModel user;


    @BeforeEach
    void setUp() {
        System.out.println(user);
        user= new UserModel();
        user.setRole(Role.BLOG_OWNER);
        user.setFirstName("Joseph");
        user.setLastName("ofodum");
        user.setEmail("ekene@yahoo.com");
        user.setPassword("12345");
    }

    @Test
    void saveUser(){
        UserModel userModel = userRepository.save(user);
        assertThat(userModel).isNotNull();
        assertThat (userModel.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    void findByEmailAndPassword() {
        userRepository.save(user);
        UserModel userModel= userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        assertThat(userModel).isNotNull();
        assertThat (userModel.getEmail()).isEqualTo(user.getEmail());


    }
}
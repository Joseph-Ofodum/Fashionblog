package com.javajoe.week9task.services;

import com.javajoe.week9task.dto.UserLoginDto;
import com.javajoe.week9task.dto.UserResponseDto;
import com.javajoe.week9task.dto.UserSignUpDto;
import com.javajoe.week9task.entities.UserModel;

public interface UserService {
    UserModel adminSignUp(UserSignUpDto userSignUpDto) throws Exception;
    UserModel userSignUp(UserSignUpDto userSignUpDto);
    UserModel userLogin(UserLoginDto userLoginDto);
    UserResponseDto findUser(Long userId);
    void deleteUser(Long UserId);
//
//    String logout();
}

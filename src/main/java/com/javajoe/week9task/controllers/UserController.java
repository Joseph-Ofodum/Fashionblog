package com.javajoe.week9task.controllers;

import com.javajoe.week9task.dto.UserLoginDto;
import com.javajoe.week9task.dto.UserResponseDto;
import com.javajoe.week9task.dto.UserSignUpDto;
import com.javajoe.week9task.entities.UserModel;
import com.javajoe.week9task.services.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

   private final UserService userService;

    @PostMapping("/adminSignUp")
    public ResponseEntity<String> adminSignup(@RequestBody UserSignUpDto userSignUpDto) throws Exception {
        userService.adminSignUp(userSignUpDto);
        return new ResponseEntity<>("Sign up successful", HttpStatus.CREATED);
    }

    @PostMapping("/userSignup")
    public ResponseEntity<String> userSignUp(@RequestBody UserSignUpDto userSignUpDto){
        userService.userSignUp(userSignUpDto);
        return new ResponseEntity<>("Sign up Successful", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDto userLoginDto){
        userService.userLogin(userLoginDto);
        return  new ResponseEntity<>("Log in successful", HttpStatus.ACCEPTED);
    }
       // TODO ask Richards and Augustine if this connection is ok.
    @GetMapping("/findUser")
    public ResponseEntity<UserResponseDto> findUser(@RequestBody Long userId){
       UserResponseDto userResponseDto= userService.findUser(userId);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestBody Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted Successfully", HttpStatus.ACCEPTED);
    }

}

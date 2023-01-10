package com.javajoe.week9task.services.ServiceImpl;

import com.javajoe.week9task.dto.UserLoginDto;
import com.javajoe.week9task.dto.UserResponseDto;
import com.javajoe.week9task.dto.UserSignUpDto;
import com.javajoe.week9task.entities.UserModel;
import com.javajoe.week9task.enums.Role;
import com.javajoe.week9task.exception.ResourceNotFoundException;
import com.javajoe.week9task.repositories.UserRepository;
import com.javajoe.week9task.services.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

  //  UserServiceImpl(UserRepository userRepository){
 //       this.userRepository= userRepository;
   // }

    @Override
    public UserModel adminSignUp(UserSignUpDto userSignUpDto) throws Exception {
        UserModel users = new UserModel();
        if(userRepository.existsByEmail(userSignUpDto.getEmail())){
            throw new Exception("user with email Already exist");
        }
        //TODO try and implement enums with their corresponding varriable name watch code with john for reference.
        users.setRole(Role.BLOG_OWNER);
        users.setFirstName(userSignUpDto.getFirstName());
        users.setLastName(userSignUpDto.getLastName());
        users.setEmail(userSignUpDto.getEmail());
        users.setPassword(userSignUpDto.getPassword());
        return userRepository.save(users);
    }
    @Override
    public UserModel userSignUp(UserSignUpDto userSignUpDto) {
        UserModel users = new UserModel();
        users.setRole(Role.CUSTOMER);
        users.setFirstName(userSignUpDto.getFirstName());
        users.setLastName(userSignUpDto.getLastName());
        users.setEmail(userSignUpDto.getEmail());
        users.setPassword(userSignUpDto.getPassword());
        return userRepository.save(users);
    }

    @Override
    public UserModel userLogin(UserLoginDto userLoginDto) {
        UserModel userModel = userRepository.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());
//        if (userModel == null).orElseThrow
//            (() -> new ResourceNotFoundException("Post not found"));
        return userModel;
    }

    @Override
    public UserResponseDto findUser(Long userId) {
    UserModel userModel1 = userRepository.findById(userId).
            orElseThrow(() -> new ResourceNotFoundException("User not found"));
        UserResponseDto userResponseDto= new UserResponseDto();
        userResponseDto.setEmail(userModel1.getEmail());
        return userResponseDto;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
//
//    @Override
//    public String Logout(){
//        httpSession.Invalidate()
//    }
}

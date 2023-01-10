package com.javajoe.week9task.services.ServiceImpl;

import com.javajoe.week9task.dto.UserSignUpDto;
import com.javajoe.week9task.entities.UserModel;
import com.javajoe.week9task.enums.Role;
import com.javajoe.week9task.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;
    UserModel user;

    @BeforeEach
    void setUp() {
        user= new UserModel();
        user.setRole(Role.BLOG_OWNER);
        user.setFirstName("Joseph");
        user.setLastName("ofodum");
        user.setEmail("ekene@yahoo.com");
        user.setPassword("12345");
    }

    @Test
    void adminSignUp() throws Exception {
        UserSignUpDto userSignUpDto = new UserSignUpDto();
        userSignUpDto.setFirstName(user.getFirstName());
        userSignUpDto.setPassword(user.getPassword());
        userSignUpDto.setLastName(user.getLastName());
        userSignUpDto.setEmail(user.getEmail());
        when(userRepository.save(any(UserModel.class))).thenReturn(user);

        UserModel userModel=userService.adminSignUp(userSignUpDto);
        assertThat(userModel).isNotNull();
        assertThat(userModel.getEmail()).isEqualTo(user.getEmail());
    }
    @Test
    void givenAlreadyExistingEmailShouldThrowAnException(){
        UserSignUpDto userSignUpDto = new UserSignUpDto();
        userSignUpDto.setFirstName(user.getFirstName());
        userSignUpDto.setPassword(user.getPassword());
        userSignUpDto.setLastName(user.getLastName());
        userSignUpDto.setEmail(user.getEmail());

        when(userRepository.existsByEmail(userSignUpDto.getEmail()))
                .thenReturn(true);
        assertThrows(Exception.class, ()-> userService.adminSignUp(userSignUpDto));
    }

    @Test
    void userSignUp() {
    }

    @Test
    void userLogin() {
    }

    @Test
    void findUser() {

    }

    @Test
    void deleteUser() {
    }
}
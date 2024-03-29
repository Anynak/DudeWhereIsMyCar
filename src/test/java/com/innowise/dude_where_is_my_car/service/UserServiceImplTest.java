package com.innowise.dude_where_is_my_car.service;

import com.innowise.dude_where_is_my_car.dto.mapers.UserMapper;
import com.innowise.dude_where_is_my_car.dto.requests.user_requests.RegisterUserRequest;
import com.innowise.dude_where_is_my_car.models.Role;
import com.innowise.dude_where_is_my_car.models.User;
import com.innowise.dude_where_is_my_car.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;

//https://www.baeldung.com/mockito-argumentcaptor
//https://www.baeldung.com/mockito-argument-matchers
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleService roleService;
    @Mock
    private UserMapper userMapper;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private BeforeRegisterUserChecker userChecker;
    @Captor
    private ArgumentCaptor<User> userCaptor;
    @InjectMocks
    private UserService userService;

    @Test
    void saveNewUserWitDefaultRoleAsUSER() {

        Mockito.when(userMapper.toUser(any(RegisterUserRequest.class))).thenReturn(new User());
        Mockito.when(roleService.getRoleByName("USER")).thenAnswer(roleName -> {
            Role role = new Role();
            role.setRoleName("USER");
            return role;
        });

        userService.registerUser(new RegisterUserRequest());

        verify(userRepository).save(userCaptor.capture());
        User savedUser = userCaptor.getValue();
        Assertions.assertNotNull(savedUser);
        Assertions.assertNotNull(savedUser.getRoles());
        Assertions.assertEquals(1, savedUser.getRoles().size());
        Assertions.assertEquals("USER", savedUser.getRoles().get(0).getRoleName());

    }

    @Test
    void saveNewUserWithEncodedPassword() {
        String password = "qwerty";
        RegisterUserRequest userRequest = new RegisterUserRequest();
        userRequest.setPassword(password);
        Mockito.when(userMapper.toUser(any(RegisterUserRequest.class))).thenReturn(new User());
        Mockito.when(passwordEncoder.encode(any(String.class))).thenReturn(password + "hash");

        userService.registerUser(userRequest);

        verify(passwordEncoder).encode(password);
        verify(userRepository).save(userCaptor.capture());
        User savedUser = userCaptor.getValue();
        Assertions.assertNotNull(savedUser.getPasswordHash());
        Assertions.assertNotEquals(password, savedUser.getPasswordHash());

    }

    @Test
    void checkUserBeforeRegistration() {
        RegisterUserRequest userRequest = new RegisterUserRequest();
        userRequest.setLogin("login");
        Mockito.when(userMapper.toUser(any(RegisterUserRequest.class))).thenReturn(new User());

        userService.registerUser(userRequest);

        verify(userChecker).check(userRequest);
    }

    @Test
    void checkThatUserRemovalIsSoft() {
        User user = new User();
        user.setIsDeleted(false);
        Optional<User> opt = Optional.of(user);
        Mockito.when(userRepository.findById(anyLong())).thenReturn(opt);

        userService.deleteUserById(1L);

        verify(userRepository).save(userCaptor.capture());
        User savedUser = userCaptor.getValue();
        Assertions.assertNotEquals(false, savedUser.getIsDeleted());
    }
}

package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.dto.mapers.UserMapper;
import com.innowise.DudeWhereIsMyCar.dto.requests.RegisterUserRequest;
import com.innowise.DudeWhereIsMyCar.models.Role;
import com.innowise.DudeWhereIsMyCar.models.User;
import com.innowise.DudeWhereIsMyCar.repositories.UserRepository;
import com.innowise.DudeWhereIsMyCar.service.impl.BeforeRegisterUserChecker;
import com.innowise.DudeWhereIsMyCar.service.impl.RoleServiceImpl;
import com.innowise.DudeWhereIsMyCar.service.impl.UserServiceImpl;
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
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleServiceImpl roleService;
    @Mock
    private UserMapper userMapper;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private BeforeRegisterUserChecker userChecker;
    @Captor
    private ArgumentCaptor<User> userCaptor;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void saveNewUserWitDefaultRoleAsUSER() {

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
    public void saveNewUserWithEncodedPassword() {
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
    public void checkUserBeforeRegistration() {
        RegisterUserRequest userRequest = new RegisterUserRequest();
        userRequest.setLogin("login");
        Mockito.when(userMapper.toUser(any(RegisterUserRequest.class))).thenReturn(new User());

        userService.registerUser(userRequest);

        verify(userChecker).check(userRequest);
    }

    @Test
    public void checkThatUserRemovalIsSoft() {
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

package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.Mappers.UserMapper;
import com.innowise.DudeWhereIsMyCar.dto.request.PageCriteria;
import com.innowise.DudeWhereIsMyCar.dto.request.RegisterUserRequest;
import com.innowise.DudeWhereIsMyCar.entity.Role;
import com.innowise.DudeWhereIsMyCar.entity.User;
import com.innowise.DudeWhereIsMyCar.exceptions.EmailAlreadyExistsException;
import com.innowise.DudeWhereIsMyCar.exceptions.PhoneNumberAlreadyExistsException;
import com.innowise.DudeWhereIsMyCar.exceptions.UserAlreadyExistsException;
import com.innowise.DudeWhereIsMyCar.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User findUserBuLogin(String login) {
        System.out.println(login);
        return userRepository.findUserByLogin(login).orElseThrow(() -> new UsernameNotFoundException("user " + login + " not found"));
    }

    @Override
    public List<User> getUsers(PageCriteria pageCriteria) {
        Pageable pageable = PageRequest.of(pageCriteria.getPageNumber(), pageCriteria.getPageSize());
        return userRepository.findAll(pageable).stream().toList();
    }


    @Override
    public User registerUser(RegisterUserRequest userRequest) {
        checkUserBeforeRegister(userRequest);
        User newUser = userMapper.toUser(userRequest);

        Role defaultRole = roleService.getRoleByName("USER");
        ArrayList<Role> defaultRoles = new ArrayList<>();
        defaultRoles.add(defaultRole);
        newUser.setRoles(defaultRoles);

        newUser.setPasswordHash(passwordEncoder.encode(userRequest.getPassword()));

        return userRepository.save(newUser);
    }

    private void checkUserBeforeRegister(RegisterUserRequest userReq) {

        boolean loginExists = userRepository.existsByLogin(userReq.getLogin());
        if (loginExists) throw new UserAlreadyExistsException("login " + userReq.getLogin() + " already exists");

        boolean emailExists = userRepository.existsByEmail(userReq.getEmail());
        if (emailExists) throw new EmailAlreadyExistsException("email " + userReq.getEmail() + " already exists");

        boolean phoneExists = userRepository.existsByPhone(userReq.getPhone());
        if (phoneExists)
            throw new PhoneNumberAlreadyExistsException("phone number " + userReq.getPhone() + " already exists");
    }

}

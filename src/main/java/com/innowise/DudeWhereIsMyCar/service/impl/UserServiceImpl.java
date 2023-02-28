package com.innowise.DudeWhereIsMyCar.service.impl;

import com.innowise.DudeWhereIsMyCar.dto.mapers.UserMapper;
import com.innowise.DudeWhereIsMyCar.dto.requests.RegisterUserRequest;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SearchUserRequest;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.exceptions.ResourceNotFoundException;
import com.innowise.DudeWhereIsMyCar.models.Role;
import com.innowise.DudeWhereIsMyCar.models.User;
import com.innowise.DudeWhereIsMyCar.repositories.UserRepository;
import com.innowise.DudeWhereIsMyCar.repositories.UserSearchRepository;
import com.innowise.DudeWhereIsMyCar.service.RoleService;
import com.innowise.DudeWhereIsMyCar.service.UserService;
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
    private final UserSearchRepository userSearchRepository;
    private final BeforeRegisterUserChecker beforeRegisterUserChecker;

    @Override
    public User findUserBuLogin(String login) {
        return userRepository.findUserByLogin(login).orElseThrow(() -> new UsernameNotFoundException("user " + login + " not found"));
    }


    @Override
    public List<User> getUsers(PageCriteria pageCriteria) {
        Pageable pageable = PageRequest.of(pageCriteria.getPageNumber() - 1, pageCriteria.getPageSize());
        return userRepository.findAll(pageable).stream().toList();
    }


    @Override
    public User registerUser(RegisterUserRequest userRequest) {
        beforeRegisterUserChecker.check(userRequest);
        User newUser = userMapper.toUser(userRequest);

        Role defaultRole = roleService.getRoleByName("USER");
        ArrayList<Role> defaultRoles = new ArrayList<>();
        defaultRoles.add(defaultRole);
        newUser.setRoles(defaultRoles);

        newUser.setPasswordHash(passwordEncoder.encode(userRequest.getPassword()));
        return userRepository.save(newUser);
    }


    public List<User> searchUser(
            SearchUserRequest searchUserRequest
            , PageCriteria pageCriteria
            , SortingCriteria sortingCriteria) {
        return userSearchRepository.search(searchUserRequest, pageCriteria, sortingCriteria);
    }

    @Override
    public User deleteUserById(Long id) {
        User user = findUserById(id);
        user.setIsDeleted(true);
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("no user with id " + id));
    }

}

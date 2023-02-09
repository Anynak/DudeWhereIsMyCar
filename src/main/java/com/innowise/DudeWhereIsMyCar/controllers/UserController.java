package com.innowise.DudeWhereIsMyCar.controllers;

import com.innowise.DudeWhereIsMyCar.DTO.mapers.UserMapper;
import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.SearchUserRequest;
import com.innowise.DudeWhereIsMyCar.DTO.responceDTO.UserResponse;
import com.innowise.DudeWhereIsMyCar.DTO.responceDTO.UserResponseFull;
import com.innowise.DudeWhereIsMyCar.model.User;
import com.innowise.DudeWhereIsMyCar.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.searchCriteria.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Validated
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;


    @GetMapping("/v1")
    public List<UserResponse> getUsers(@Valid PageCriteria pageCriteria) {
        List<User> users = userService.getUsers(pageCriteria);
        List<UserResponse> userResponses = userMapper.toUserResponse(users);
        return userResponses;

    }

    @GetMapping("/v1/search")
    public List<UserResponseFull> findUsers(
            @Valid SearchUserRequest searchUserRequest,
            @Valid PageCriteria pageCriteria,
            @Valid SortingCriteria sortingCriteria) {

        List<User> users = userService.searchUser(searchUserRequest, pageCriteria, sortingCriteria);
        return userMapper.toUserResponseFull(users);
    }

    @DeleteMapping("/v1/{id}")
    public UserResponseFull deleteUser(@Valid @PathVariable Long id) {
        User deletedUser = userService.deleteUserById(id);
        return userMapper.toUserResponseFull(deletedUser);
    }
}

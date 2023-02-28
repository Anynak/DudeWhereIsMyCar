package com.innowise.DudeWhereIsMyCar.controllers;

import com.innowise.DudeWhereIsMyCar.dto.mapers.UserMapper;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SearchUserRequest;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.dto.responses.UserResponse;
import com.innowise.DudeWhereIsMyCar.dto.responses.UserResponseFull;
import com.innowise.DudeWhereIsMyCar.models.User;
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
        return userMapper.toUserResponse(users);

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

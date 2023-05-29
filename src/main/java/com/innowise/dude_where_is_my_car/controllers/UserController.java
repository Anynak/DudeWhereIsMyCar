package com.innowise.dude_where_is_my_car.controllers;

import com.innowise.dude_where_is_my_car.dto.mapers.UserMapper;
import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.PageCriteria;
import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.SearchUserRequest;
import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.SortingCriteria;
import com.innowise.dude_where_is_my_car.dto.responses.UserResponse;
import com.innowise.dude_where_is_my_car.dto.responses.UserResponseFull;
import com.innowise.dude_where_is_my_car.models.User;
import com.innowise.dude_where_is_my_car.service.QUserService;
import com.innowise.dude_where_is_my_car.service.UserService;
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
    private final QUserService qUserService;
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

        List<User> users = qUserService.searchUser(searchUserRequest, pageCriteria, sortingCriteria);
        return userMapper.toUserResponseFull(users);
    }

    @DeleteMapping("/v1/{id}")
    public UserResponseFull deleteUser(@Valid @PathVariable Long id) {
        User deletedUser = userService.deleteUserById(id);
        return userMapper.toUserResponseFull(deletedUser);
    }
}

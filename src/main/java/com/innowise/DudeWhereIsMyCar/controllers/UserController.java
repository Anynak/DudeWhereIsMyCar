package com.innowise.DudeWhereIsMyCar.controllers;

import com.innowise.DudeWhereIsMyCar.Mappers.UserMapper;
import com.innowise.DudeWhereIsMyCar.dto.request.PageCriteria;
import com.innowise.DudeWhereIsMyCar.dto.request.SearchUserRequest;
import com.innowise.DudeWhereIsMyCar.dto.request.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.dto.response.UserResponse;
import com.innowise.DudeWhereIsMyCar.entity.User;
import com.innowise.DudeWhereIsMyCar.repositories.UserSearchRepository;
import com.innowise.DudeWhereIsMyCar.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Validated
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final UserSearchRepository userSearchRepository;

    @GetMapping("/get")
    public ResponseEntity<?> getUsers(@Valid PageCriteria pageCriteria) {
        List<User> users = userService.getUsers(pageCriteria);
        List<UserResponse> userResponses = userMapper.toUserResponse(users);
        return new ResponseEntity<>(userResponses, HttpStatus.OK);

    }

    @GetMapping("/find")
    public ResponseEntity<?> findUsers(
            @Valid SearchUserRequest searchUserRequest,
            @Valid PageCriteria pageCriteria,
            @Valid SortingCriteria sortingCriteria) {

        List<User> users = userSearchRepository.findAll(searchUserRequest, pageCriteria, sortingCriteria);
        return new ResponseEntity<>(userMapper.toUserResponseFull(users), HttpStatus.OK);
    }
}

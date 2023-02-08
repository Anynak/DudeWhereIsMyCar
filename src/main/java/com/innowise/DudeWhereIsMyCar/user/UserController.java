package com.innowise.DudeWhereIsMyCar.user;

import com.innowise.DudeWhereIsMyCar.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.searchCriteria.SortingCriteria;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Validated
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;


    @GetMapping("/user")
    public ResponseEntity<List<UserResponse>> getUsers(@Valid PageCriteria pageCriteria) {
        List<User> users = userService.getUsers(pageCriteria);
        List<UserResponse> userResponses = userMapper.toUserResponse(users);
        return new ResponseEntity<>(userResponses, HttpStatus.OK);

    }

    @GetMapping("/user/search")
    public ResponseEntity<List<UserResponseFull>> findUsers(
            @Valid SearchUserRequest searchUserRequest,
            @Valid PageCriteria pageCriteria,
            @Valid SortingCriteria sortingCriteria) {

        List<User> users = userService.searchUser(searchUserRequest, pageCriteria, sortingCriteria);
        return new ResponseEntity<>(userMapper.toUserResponseFull(users), HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<UserResponseFull> deleteUser(@Valid @PathVariable Long id) {
        User deletedUser = userService.deleteUserById(id);
        return new ResponseEntity<>(userMapper.toUserResponseFull(deletedUser), HttpStatus.OK);
    }
}

package com.innowise.dude_where_is_my_car.service;

import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.PageCriteria;
import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.SearchUserRequest;
import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.SortingCriteria;
import com.innowise.dude_where_is_my_car.dto.requests.user_requests.RegisterUserRequest;
import com.innowise.dude_where_is_my_car.models.User;

import java.util.List;

public interface UserService {
    User findUserBuLogin(String login);

    List<User> getUsers(PageCriteria pageCriteria);

    User registerUser(RegisterUserRequest userRequest);

    List<User> searchUser(
            SearchUserRequest searchUserRequest
            , PageCriteria pageCriteria
            , SortingCriteria sortingCriteria);

    User deleteUserById(Long id);

    User findUserById(Long id);
}

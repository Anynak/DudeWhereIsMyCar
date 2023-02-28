package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.dto.requests.RegisterUserRequest;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SearchUserRequest;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.models.User;

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

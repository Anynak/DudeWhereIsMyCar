package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.RegisterUserRequest;
import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.SearchUserRequest;
import com.innowise.DudeWhereIsMyCar.model.User;
import com.innowise.DudeWhereIsMyCar.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.searchCriteria.SortingCriteria;

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

package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.dto.request.PageCriteria;
import com.innowise.DudeWhereIsMyCar.dto.request.RegisterUserRequest;
import com.innowise.DudeWhereIsMyCar.dto.request.SearchUserRequest;
import com.innowise.DudeWhereIsMyCar.dto.request.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.entity.User;

import java.util.List;

public interface UserService {
    User findUserBuLogin(String login);
    List<User> getUsers(PageCriteria pageCriteria);
    User registerUser(RegisterUserRequest userRequest);
    List<User> searchUser(
            SearchUserRequest searchUserRequest
            , PageCriteria pageCriteria
            , SortingCriteria sortingCriteria);
}

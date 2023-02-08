package com.innowise.DudeWhereIsMyCar.user;

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

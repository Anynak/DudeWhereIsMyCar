package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SearchUserRequest;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.models.User;

import java.util.List;

public interface QUserService {
    List<User> searchUser(SearchUserRequest searchRequest, PageCriteria pageCriteria, SortingCriteria sortingCriteria);
}

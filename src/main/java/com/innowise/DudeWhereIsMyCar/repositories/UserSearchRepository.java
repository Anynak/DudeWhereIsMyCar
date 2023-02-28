package com.innowise.DudeWhereIsMyCar.repositories;

import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SearchUserRequest;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.models.User;

import java.util.List;

public interface UserSearchRepository {
    List<User> search(SearchUserRequest searchUserRequest, PageCriteria pageCriteria, SortingCriteria sortingCriteria);
}

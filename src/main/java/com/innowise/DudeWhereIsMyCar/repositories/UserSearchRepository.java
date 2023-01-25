package com.innowise.DudeWhereIsMyCar.repositories;

import com.innowise.DudeWhereIsMyCar.dto.request.PageCriteria;
import com.innowise.DudeWhereIsMyCar.dto.request.SearchUserRequest;
import com.innowise.DudeWhereIsMyCar.dto.request.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.entity.User;

import java.util.List;

public interface UserSearchRepository {
    List<User> search(SearchUserRequest searchUserRequest, PageCriteria pageCriteria, SortingCriteria sortingCriteria);
}

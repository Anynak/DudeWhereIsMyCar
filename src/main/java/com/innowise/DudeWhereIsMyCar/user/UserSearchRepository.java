package com.innowise.DudeWhereIsMyCar.user;

import com.innowise.DudeWhereIsMyCar.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.searchCriteria.SortingCriteria;

import java.util.List;

public interface UserSearchRepository {
    List<User> search(SearchUserRequest searchUserRequest, PageCriteria pageCriteria, SortingCriteria sortingCriteria);
}

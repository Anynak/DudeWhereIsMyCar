package com.innowise.dude_where_is_my_car.repositories;

import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.PageCriteria;
import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.SearchUserRequest;
import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.SortingCriteria;
import com.innowise.dude_where_is_my_car.models.User;

import java.util.List;

public interface UserSearchRepository {
    List<User> search(SearchUserRequest searchUserRequest, PageCriteria pageCriteria, SortingCriteria sortingCriteria);
}

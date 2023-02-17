package com.innowise.DudeWhereIsMyCar.repositories;

import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.searchCriteria.SearchUserRequest;
import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.searchCriteria.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.model.User;

import java.util.List;

public interface UserSearchRepository {
    List<User> search(SearchUserRequest searchUserRequest, PageCriteria pageCriteria, SortingCriteria sortingCriteria);
}

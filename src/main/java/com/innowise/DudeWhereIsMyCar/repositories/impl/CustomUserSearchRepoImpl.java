package com.innowise.DudeWhereIsMyCar.repositories.impl;

import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SearchUserRequest;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.models.User;
import com.innowise.DudeWhereIsMyCar.repositories.CustomUserSearchRepo;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.innowise.DudeWhereIsMyCar.models.QUser.user;

@Repository
@RequiredArgsConstructor
public class CustomUserSearchRepoImpl implements CustomUserSearchRepo {
    private final EntityManager entityManager;

    @Override
    public List<User> search(SearchUserRequest searchRequest, PageCriteria pageCriteria, SortingCriteria sortingCriteria) {
        return new JPAQuery<User>(entityManager)
                .select(user)
                .from(user)
                .where(user.country.containsIgnoreCase(searchRequest.getCountry())
                        .and(user.city.containsIgnoreCase(searchRequest.getCity())))
                .fetch();
    }
}

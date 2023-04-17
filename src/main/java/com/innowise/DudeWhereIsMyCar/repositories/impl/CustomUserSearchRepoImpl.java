package com.innowise.DudeWhereIsMyCar.repositories.impl;

import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SearchUserRequest;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.models.User;
import com.innowise.DudeWhereIsMyCar.repositories.CustomUserSearchRepo;
import com.innowise.DudeWhereIsMyCar.repositories.utils.QPredicates;
import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.ComparableExpressionBase;

import com.querydsl.core.types.dsl.PathBuilder;
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

        Predicate searchRequestPredicate = QPredicates.builder()
                .add(searchRequest.getCountry(), user.country::containsIgnoreCase)
                .add(searchRequest.getCity(), user.city::containsIgnoreCase)
                .buildAnd();

        OrderSpecifier<?> orderSpecifier = user.userId.asc();

        if(sortingCriteria.getSortBy()!=null){
            PathBuilder<User> pathBuilder = new PathBuilder<>(User.class, user.toString());
            ComparableExpressionBase<?> path = pathBuilder.getString(sortingCriteria.getSortBy());
            orderSpecifier = path.asc();
        }

        return new JPAQuery<User>(entityManager)
                .select(user)
                .from(user)
                .where(searchRequestPredicate)
                .offset(pageCriteria.getPageNumber())
                .limit(pageCriteria.getPageSize()).orderBy(orderSpecifier)
                .fetch();
    }
}

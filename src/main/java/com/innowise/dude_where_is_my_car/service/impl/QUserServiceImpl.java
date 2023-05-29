package com.innowise.dude_where_is_my_car.service.impl;

import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.PageCriteria;
import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.SearchUserRequest;
import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.SortingCriteria;
import com.innowise.dude_where_is_my_car.models.User;
import com.innowise.dude_where_is_my_car.repositories.QUserSearchRepository;
import com.innowise.dude_where_is_my_car.service.QUserService;
import com.innowise.dude_where_is_my_car.service.utils.QPredicates;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.ComparableExpressionBase;
import com.querydsl.core.types.dsl.PathBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.innowise.dude_where_is_my_car.models.QUser.user;

@Service
@RequiredArgsConstructor
public class QUserServiceImpl implements QUserService {
    private final QUserSearchRepository qUserSearchRepo;

    @Override
    public List<User> searchUser(SearchUserRequest searchRequest, PageCriteria pageCriteria, SortingCriteria sortingCriteria) {

        Predicate searchRequestPredicate = QPredicates.builder()
                .add(searchRequest.getCountry(), user.country::containsIgnoreCase)
                .add(searchRequest.getCity(), user.city::containsIgnoreCase)
                .buildAnd();

        OrderSpecifier<?> orderSpecifier = user.userId.asc();
        if (sortingCriteria.getSortBy() != null) {
            PathBuilder<User> pathBuilder = new PathBuilder<>(User.class, user.toString());
            ComparableExpressionBase<?> path = pathBuilder.getString(sortingCriteria.getSortBy());
            if (!sortingCriteria.getAsc()) {
                orderSpecifier = path.desc();
            } else {
                orderSpecifier = path.asc();
            }
        }

        return qUserSearchRepo.searchUser(searchRequestPredicate, orderSpecifier, pageCriteria);
    }
}

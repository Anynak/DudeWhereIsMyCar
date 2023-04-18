package com.innowise.DudeWhereIsMyCar.service.impl;

import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SearchUserRequest;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.models.User;
import com.innowise.DudeWhereIsMyCar.repositories.QUserSearchRepository;
import com.innowise.DudeWhereIsMyCar.service.QUserService;
import com.innowise.DudeWhereIsMyCar.service.utils.QPredicates;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.ComparableExpressionBase;
import com.querydsl.core.types.dsl.PathBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.innowise.DudeWhereIsMyCar.models.QUser.user;

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
            if (!sortingCriteria.getASC()) {
                orderSpecifier = path.desc();
            } else {
                orderSpecifier = path.asc();
            }
        }

        return qUserSearchRepo.searchUser(searchRequestPredicate, orderSpecifier, pageCriteria);
    }
}

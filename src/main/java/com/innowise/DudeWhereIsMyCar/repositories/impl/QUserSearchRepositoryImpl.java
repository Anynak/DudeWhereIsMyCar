package com.innowise.DudeWhereIsMyCar.repositories.impl;

import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.models.User;
import com.innowise.DudeWhereIsMyCar.repositories.QUserSearchRepository;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.innowise.DudeWhereIsMyCar.models.QUser.user;

@Repository
@RequiredArgsConstructor
public class QUserSearchRepositoryImpl implements QUserSearchRepository {
    private final EntityManager entityManager;
    @Override
    public List<User> searchUser(Predicate searchRequestPredicate, OrderSpecifier<?> orderSpecifier, PageCriteria pageCriteria) {
        return new JPAQuery<User>(entityManager)
                .select(user)
                .from(user)
                .where(searchRequestPredicate)
                .offset(pageCriteria.getPageNumber())
                .limit(pageCriteria.getPageSize())
                .orderBy(orderSpecifier)
                .fetch();
    }
}

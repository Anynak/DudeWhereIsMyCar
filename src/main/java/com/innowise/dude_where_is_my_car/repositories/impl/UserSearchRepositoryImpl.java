package com.innowise.dude_where_is_my_car.repositories.impl;

import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.PageCriteria;
import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.SearchUserRequest;
import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.SortingCriteria;
import com.innowise.dude_where_is_my_car.models.User;
import com.innowise.dude_where_is_my_car.repositories.UserSearchRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserSearchRepositoryImpl implements UserSearchRepository {
    private final EntityManager em;

    @Override
    public List<User> search(SearchUserRequest searchRequest, PageCriteria pageCriteria, SortingCriteria sortingCriteria) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);

        if (sortingCriteria != null && sortingCriteria.getSortBy() != null) {
            Boolean isAsc = sortingCriteria.getAsc();
            if (Boolean.TRUE.equals(isAsc)) {
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get(sortingCriteria.getSortBy())));
            } else {
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get(sortingCriteria.getSortBy())));
            }
        }

        List<Predicate> predicates = createPredicate(searchRequest, criteriaBuilder, root);

        if (!predicates.isEmpty()) {
            Predicate orPredicate = criteriaBuilder.or(predicates.toArray(new Predicate[0]));
            criteriaQuery.where(orPredicate);
        }

        TypedQuery<User> query = em.createQuery(criteriaQuery);
        if (pageCriteria != null) {
            query.setFirstResult((pageCriteria.getPageNumber() - 1) * pageCriteria.getPageSize());
            query.setMaxResults(pageCriteria.getPageSize());
        }


        return query.getResultList();
    }

    private List<Predicate> createPredicate(SearchUserRequest searchRequest, CriteriaBuilder criteriaBuilder, Root<User> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (searchRequest.getCountry() != null) {
            Predicate countryPredicate = criteriaBuilder
                    .like(root.get("country"), "%" + searchRequest.getCountry() + "%");
            predicates.add(countryPredicate);
        }

        if (searchRequest.getCity() != null) {
            Predicate cityPredicate = criteriaBuilder
                    .like(root.get("city"), "%" + searchRequest.getCity() + "%");
            predicates.add(cityPredicate);
        }
        return predicates;
    }
}

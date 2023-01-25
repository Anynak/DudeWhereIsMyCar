package com.innowise.DudeWhereIsMyCar.repositories;

import com.innowise.DudeWhereIsMyCar.dto.request.PageCriteria;
import com.innowise.DudeWhereIsMyCar.dto.request.SearchAnnouncementRequest;
import com.innowise.DudeWhereIsMyCar.dto.request.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.entity.Announcement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AnnouncementSearchRepositoryImpl implements AnnouncementSearchRepository {
    private final EntityManager em;

    @Override
    public List<Announcement> search(SearchAnnouncementRequest searchRequest, PageCriteria pageCriteria, SortingCriteria sortingCriteria) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Announcement> criteriaQuery = criteriaBuilder.createQuery(Announcement.class);

        Root<Announcement> root = criteriaQuery.from(Announcement.class);

        if (sortingCriteria.getASC()) {
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(sortingCriteria.getSortBy())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get(sortingCriteria.getSortBy())));
        }

        Predicate priceRangePredicate = criteriaBuilder.between(root.get("price"), searchRequest.getMinPrice(), searchRequest.getMaxPrice());
        criteriaQuery.where(priceRangePredicate);
        TypedQuery<Announcement> query = em.createQuery(criteriaQuery);
        if (pageCriteria != null) {
            query.setFirstResult((pageCriteria.getPageNumber() - 1) * pageCriteria.getPageSize());
            query.setMaxResults(pageCriteria.getPageSize());
        }
        return query.getResultList();
    }
}

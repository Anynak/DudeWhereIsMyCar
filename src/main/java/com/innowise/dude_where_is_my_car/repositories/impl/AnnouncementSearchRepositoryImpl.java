package com.innowise.dude_where_is_my_car.repositories.impl;

import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.PageCriteria;
import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.SearchAnnouncementRequest;
import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.SortingCriteria;
import com.innowise.dude_where_is_my_car.models.Announcement;
import com.innowise.dude_where_is_my_car.repositories.AnnouncementSearchRepository;
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
public class AnnouncementSearchRepositoryImpl implements AnnouncementSearchRepository {
    private final EntityManager em;

    @Override
    public List<Announcement> search(SearchAnnouncementRequest searchRequest, PageCriteria pageCriteria, SortingCriteria sortingCriteria) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Announcement> criteriaQuery = criteriaBuilder.createQuery(Announcement.class);

        Root<Announcement> root = criteriaQuery.from(Announcement.class);

        if (sortingCriteria.getSortBy() != null) {
            Boolean isAsc = sortingCriteria.getAsc();
            if (Boolean.TRUE.equals(isAsc)) {
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get(sortingCriteria.getSortBy())));
            } else {
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get(sortingCriteria.getSortBy())));
            }
        }

        List<Predicate> predicates = new ArrayList<>();

        Predicate isDeletedPredicate = criteriaBuilder.isFalse(root.get("isDeleted"));
        predicates.add(isDeletedPredicate);

        Predicate priceRangePredicate = criteriaBuilder.between(root.get("price"), searchRequest.getPriceMin(), searchRequest.getPriceMax());
        predicates.add(priceRangePredicate);

        String vehicleAttributeName = "vehicle";
        Predicate mileageRangePredicate = criteriaBuilder.between(root.get(vehicleAttributeName).get("mileage"), searchRequest.getMileageMin(), searchRequest.getMileageMax());
        predicates.add(mileageRangePredicate);
//
        Predicate releaseYearRangePredicate = criteriaBuilder.between(root.get(vehicleAttributeName).get("releaseYear"), searchRequest.getReleaseYearMin(), searchRequest.getReleaseYearMax());
        predicates.add(releaseYearRangePredicate);

        if (searchRequest.getColor() != null) {
            Predicate colorPredicate = criteriaBuilder.like(root.get(vehicleAttributeName).get("color"), "%" + searchRequest.getColor() + "%");
            predicates.add(colorPredicate);
        }
//
        if (searchRequest.getVehicleBrandName() != null) {
            Predicate brandPredicate = criteriaBuilder.like(root.get(vehicleAttributeName).get("vehicleModel").get("vehicleBrand").get("vehicleBrandName"), "%" + searchRequest.getVehicleBrandName() + "%");
            predicates.add(brandPredicate);
        }
//
        if (searchRequest.getVehicleModelName() != null) {
            Predicate modelPredicate = criteriaBuilder.like(root.get("vehicle").get("vehicleModel").get("vehicleModelName"), "%" + searchRequest.getVehicleModelName() + "%");
            predicates.add(modelPredicate);
        }


        Predicate andPredicate = criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        criteriaQuery.where(andPredicate);
        TypedQuery<Announcement> query = em.createQuery(criteriaQuery);
        if (pageCriteria != null) {
            query.setFirstResult((pageCriteria.getPageNumber() - 1) * pageCriteria.getPageSize());
            query.setMaxResults(pageCriteria.getPageSize());
        }
        return query.getResultList();
    }
}

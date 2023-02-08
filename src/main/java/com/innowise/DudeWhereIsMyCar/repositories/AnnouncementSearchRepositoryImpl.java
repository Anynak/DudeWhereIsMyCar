package com.innowise.DudeWhereIsMyCar.repositories;

import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.SearchAnnouncementRequest;
import com.innowise.DudeWhereIsMyCar.model.Announcement;
import com.innowise.DudeWhereIsMyCar.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.searchCriteria.SortingCriteria;
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

        if (sortingCriteria.getASC()) {
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(sortingCriteria.getSortBy())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get(sortingCriteria.getSortBy())));
        }

        List<Predicate> predicates = new ArrayList<>();

        Predicate isDeletedPredicate = criteriaBuilder.isFalse(root.get("isDeleted"));
        predicates.add(isDeletedPredicate);

        Predicate priceRangePredicate = criteriaBuilder.between(root.get("price"), searchRequest.getPriceMin(), searchRequest.getPriceMax());
        predicates.add(priceRangePredicate);

        Predicate mileageRangePredicate = criteriaBuilder.between(root.get("vehicle").get("mileage"), searchRequest.getMileageMin(), searchRequest.getMileageMax());
        predicates.add(mileageRangePredicate);

        Predicate releaseYearRangePredicate = criteriaBuilder.between(root.get("vehicle").get("releaseYear"), searchRequest.getReleaseYearMin(), searchRequest.getReleaseYearMax());
        predicates.add(releaseYearRangePredicate);

        if (searchRequest.getColor() != null) {
            Predicate colorPredicate = criteriaBuilder.like(root.get("vehicle").get("color"), "%" + searchRequest.getColor() + "%");
            predicates.add(colorPredicate);
        }

        if (searchRequest.getVehicleBrandName() != null) {
            Predicate brandPredicate = criteriaBuilder.like(root.get("vehicle").get("vehicleModel").get("vehicleBrand").get("vehicleBrandName"), "%" + searchRequest.getVehicleBrandName() + "%");
            predicates.add(brandPredicate);
        }

        if (searchRequest.getVehicleModelName() != null) {
            Predicate modelPredicate = criteriaBuilder.like(root.get("vehicle").get("vehicleModel").get("vehicleModelName"), "%" + searchRequest.getVehicleModelName() + "%");
            predicates.add(modelPredicate);
        }

        if (searchRequest.getVehicleTypeName() != null) {
            Predicate modelPredicate = criteriaBuilder.like(root.get("vehicle").get("vehicleType").get("typeName"), "%" + searchRequest.getVehicleTypeName() + "%");
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

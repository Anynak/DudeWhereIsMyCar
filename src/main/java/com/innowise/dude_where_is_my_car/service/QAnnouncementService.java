package com.innowise.dude_where_is_my_car.service;

import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.PageCriteria;
import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.SearchAnnouncementRequest;
import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.SortingCriteria;
import com.innowise.dude_where_is_my_car.models.Announcement;
import com.innowise.dude_where_is_my_car.repositories.QAnnouncementSearchRepository;
import com.innowise.dude_where_is_my_car.service.utils.QPredicates;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.ComparableExpressionBase;
import com.querydsl.core.types.dsl.PathBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.innowise.dude_where_is_my_car.models.QAnnouncement.announcement;

@Service
@RequiredArgsConstructor
public class QAnnouncementService {

    private final QAnnouncementSearchRepository qAnnouncementRepository;


    public List<Announcement> searchAnnouncement(SearchAnnouncementRequest searchRequest, PageCriteria pageCriteria, SortingCriteria sortingCriteria) {
//https://github.com/querydsl/querydsl/issues/2129
        Predicate searchRequestPredicate = QPredicates.builder()
                .add(searchRequest.getVehicleBrandName(), announcement.vehicle.vehicleModel.vehicleBrand.vehicleBrandName::like)
                .add(searchRequest.getVehicleModelName(), announcement.vehicle.vehicleModel.vehicleModelName::like)
                .add(searchRequest.getColor(), announcement.vehicle.color::like)
                .add(searchRequest.getPriceMax(), announcement.price::loe)
                .add(searchRequest.getPriceMin(), announcement.price::goe)
                .add(searchRequest.getMileageMax(), announcement.vehicle.mileage::loe)
                .add(searchRequest.getMileageMin(), announcement.vehicle.mileage::goe)
                .add(searchRequest.getReleaseYearMax(), announcement.vehicle.releaseYear::loe)
                .add(searchRequest.getReleaseYearMin(), announcement.vehicle.releaseYear::goe)
                .buildAnd();

        OrderSpecifier<?> orderSpecifier = announcement.announcementId.asc();
        if (sortingCriteria.getSortBy() != null) {
            PathBuilder<Announcement> pathBuilder = new PathBuilder<>(Announcement.class, announcement.toString());
            ComparableExpressionBase<?> path = pathBuilder.getString(sortingCriteria.getSortBy());
            Boolean isAsc = sortingCriteria.getAsc();
            if (Boolean.FALSE.equals(isAsc)) {
                orderSpecifier = path.desc();
            } else {
                orderSpecifier = path.asc();
            }
        }

        return qAnnouncementRepository.searchAnnouncement(searchRequestPredicate, orderSpecifier, pageCriteria);
    }
}

package com.innowise.DudeWhereIsMyCar.service.impl;

import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SearchAnnouncementRequest;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.models.Announcement;
import com.innowise.DudeWhereIsMyCar.repositories.QAnnouncementSearchRepository;
import com.innowise.DudeWhereIsMyCar.service.QAnnouncementService;
import com.innowise.DudeWhereIsMyCar.service.utils.QPredicates;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.ComparableExpressionBase;
import com.querydsl.core.types.dsl.PathBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.innowise.DudeWhereIsMyCar.models.QAnnouncement.announcement;

@Service
@RequiredArgsConstructor
public class QAnnouncementServiceImpl implements QAnnouncementService {

    private final QAnnouncementSearchRepository qAnnouncementRepository;

    @Override
    public List<Announcement> searchAnnouncement(SearchAnnouncementRequest searchRequest, PageCriteria pageCriteria, SortingCriteria sortingCriteria) {
//https://github.com/querydsl/querydsl/issues/2129
        Predicate searchRequestPredicate = QPredicates.builder()
                //todo fix this
                //.add(searchRequest.getVehicleBrandName(), announcement.vehicle.vehicleModel.vehicleBrand.vehicleBrandName::like)
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
            if (!sortingCriteria.getASC()) {
                orderSpecifier = path.desc();
            } else {
                orderSpecifier = path.asc();
            }
        }

        return qAnnouncementRepository.searchAnnouncement(searchRequestPredicate, orderSpecifier, pageCriteria);
    }
}

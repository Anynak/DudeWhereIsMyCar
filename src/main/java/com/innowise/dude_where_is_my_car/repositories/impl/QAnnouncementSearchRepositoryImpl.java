package com.innowise.dude_where_is_my_car.repositories.impl;

import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.PageCriteria;
import com.innowise.dude_where_is_my_car.models.Announcement;
import com.innowise.dude_where_is_my_car.repositories.QAnnouncementSearchRepository;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.innowise.dude_where_is_my_car.models.QAnnouncement.announcement;

@Repository
@RequiredArgsConstructor
public class QAnnouncementSearchRepositoryImpl implements QAnnouncementSearchRepository {
    private final EntityManager entityManager;

    @Override
    public List<Announcement> searchAnnouncement(Predicate searchRequestPredicate, OrderSpecifier<?> orderSpecifier, PageCriteria pageCriteria) {
        return new JPAQuery<Announcement>(entityManager)
                .select(announcement)
                .from(announcement)
                .where(searchRequestPredicate)
                .offset(pageCriteria.getPageNumber())
                .limit(pageCriteria.getPageSize())
                .orderBy(orderSpecifier)
                .fetch();
    }
}

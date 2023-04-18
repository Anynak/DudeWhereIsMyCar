package com.innowise.DudeWhereIsMyCar.repositories.impl;

import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.models.Announcement;
import com.innowise.DudeWhereIsMyCar.repositories.QAnnouncementSearchRepository;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.innowise.DudeWhereIsMyCar.models.QAnnouncement.announcement;

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

package com.innowise.dude_where_is_my_car.repositories;

import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.PageCriteria;
import com.innowise.dude_where_is_my_car.models.Announcement;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;

import java.util.List;

public interface QAnnouncementSearchRepository {
    List<Announcement> searchAnnouncement(Predicate searchRequestPredicate, OrderSpecifier<?> orderSpecifier, PageCriteria pageCriteria);
}

package com.innowise.dude_where_is_my_car.service;

import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.PageCriteria;
import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.SearchAnnouncementRequest;
import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.SortingCriteria;
import com.innowise.dude_where_is_my_car.dto.responses.AnnouncementResponse;
import com.innowise.dude_where_is_my_car.models.Announcement;

import java.util.List;

public interface AnnouncementService {
    Announcement saveAnnouncement(Announcement announcement);

    Announcement getById(Long id);

    List<Announcement> searchAnnouncement(
            SearchAnnouncementRequest searchAnnouncementRequest
            , PageCriteria pageCriteria
            , SortingCriteria sortingCriteria);

    Announcement deleteAnnouncement(Long id);

    List<AnnouncementResponse> convertAnnouncementPrice(List<AnnouncementResponse> announcements, String from, String to);

}

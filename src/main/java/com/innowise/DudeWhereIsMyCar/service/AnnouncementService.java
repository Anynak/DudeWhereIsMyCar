package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SearchAnnouncementRequest;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.dto.responses.AnnouncementResponse;
import com.innowise.DudeWhereIsMyCar.models.Announcement;

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

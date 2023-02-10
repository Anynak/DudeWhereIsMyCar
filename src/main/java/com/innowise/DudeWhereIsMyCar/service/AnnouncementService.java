package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.SearchAnnouncementRequest;
import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.searchCriteria.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.model.Announcement;

import java.util.List;

public interface AnnouncementService {
    Announcement saveAnnouncement(Announcement announcement);

    Announcement getById(Long id);

    List<Announcement> searchAnnouncement(
            SearchAnnouncementRequest searchAnnouncementRequest
            , PageCriteria pageCriteria
            , SortingCriteria sortingCriteria);

    Announcement deleteAnnouncement(Long id);

}

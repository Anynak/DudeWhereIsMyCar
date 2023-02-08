package com.innowise.DudeWhereIsMyCar.announcement;

import com.innowise.DudeWhereIsMyCar.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.searchCriteria.SortingCriteria;

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

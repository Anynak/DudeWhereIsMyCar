package com.innowise.DudeWhereIsMyCar.announcement;

import com.innowise.DudeWhereIsMyCar.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.searchCriteria.SortingCriteria;

import java.util.List;

public interface AnnouncementSearchRepository {
    List<Announcement> search(SearchAnnouncementRequest searchAnnouncementRequest, PageCriteria pageCriteria, SortingCriteria sortingCriteria);
}

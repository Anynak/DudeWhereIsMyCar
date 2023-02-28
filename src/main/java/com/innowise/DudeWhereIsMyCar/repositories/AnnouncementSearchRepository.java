package com.innowise.DudeWhereIsMyCar.repositories;

import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SearchAnnouncementRequest;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.models.Announcement;

import java.util.List;

public interface AnnouncementSearchRepository {
    List<Announcement> search(SearchAnnouncementRequest searchAnnouncementRequest, PageCriteria pageCriteria, SortingCriteria sortingCriteria);
}

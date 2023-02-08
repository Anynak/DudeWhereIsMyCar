package com.innowise.DudeWhereIsMyCar.announcement;

import com.innowise.DudeWhereIsMyCar.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.searchCriteria.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private final AnnouncementSearchRepository announcementSearchRepository;

    @Override
    public Announcement saveAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    @Override
    public Announcement getById(Long id) {
        return announcementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("announcement with id " + id + " not found"));
    }

    @Override
    public List<Announcement> searchAnnouncement(SearchAnnouncementRequest searchAnnouncementRequest, PageCriteria pageCriteria, SortingCriteria sortingCriteria) {
        return announcementSearchRepository.search(searchAnnouncementRequest, pageCriteria, sortingCriteria);
    }

    @Override
    public Announcement deleteAnnouncement(Long id) {
        Announcement announcement = getById(id);
        announcement.setIsDeleted(true);
        return announcementRepository.save(announcement);
    }
}

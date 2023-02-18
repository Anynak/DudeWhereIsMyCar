package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.searchCriteria.SearchAnnouncementRequest;
import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.searchCriteria.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.clients.CurrencyClient;
import com.innowise.DudeWhereIsMyCar.clients.DTO.CurrencyRate;
import com.innowise.DudeWhereIsMyCar.exceptions.ResourceNotFoundException;
import com.innowise.DudeWhereIsMyCar.model.Announcement;
import com.innowise.DudeWhereIsMyCar.repositories.AnnouncementRepository;
import com.innowise.DudeWhereIsMyCar.repositories.AnnouncementSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private final AnnouncementSearchRepository announcementSearchRepository;
    private final CurrencyClient currencyClient;

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

    @Override
    public List<Announcement> convertAnnouncementPrice(List<Announcement> announcements, String from, String to) {
        CurrencyRate currencyRate = currencyClient.getCurrencyRate(from, to);
        return announcements.stream()
                .map(a -> new Announcement(
                        a.getAnnouncementId(),
                        a.getVehicle(), a.getUser(),
                        a.getPrice() * currencyRate.result,
                        a.getComment(),
                        a.getIsDeleted())).toList();

    }


}

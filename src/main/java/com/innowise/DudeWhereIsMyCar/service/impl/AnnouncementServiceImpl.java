package com.innowise.DudeWhereIsMyCar.service.impl;

import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SearchAnnouncementRequest;
import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.dto.responses.AnnouncementResponse;
import com.innowise.DudeWhereIsMyCar.exceptions.ResourceNotFoundException;
import com.innowise.DudeWhereIsMyCar.external.feign.CurrencyClient;
import com.innowise.DudeWhereIsMyCar.external.feign.dto.CurrencyRate;
import com.innowise.DudeWhereIsMyCar.models.Announcement;
import com.innowise.DudeWhereIsMyCar.repositories.AnnouncementRepository;
import com.innowise.DudeWhereIsMyCar.repositories.AnnouncementSearchRepository;
import com.innowise.DudeWhereIsMyCar.service.AnnouncementService;
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
    public List<AnnouncementResponse> convertAnnouncementPrice(List<AnnouncementResponse> announcements, String from, String to) {
        CurrencyRate currencyRate = currencyClient.getCurrencyRate(from.toUpperCase(), to.toUpperCase());
        return announcements.stream()
                .map(a -> new AnnouncementResponse(
                        a.getAnnouncementId(),
                        a.getVehicle(),
                        a.getPrice() * currencyRate.result,
                        to,
                        a.getComment()))
                .toList();
    }
}

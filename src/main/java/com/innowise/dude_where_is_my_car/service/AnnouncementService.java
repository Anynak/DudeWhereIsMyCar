package com.innowise.dude_where_is_my_car.service;

import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.PageCriteria;
import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.SearchAnnouncementRequest;
import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.SortingCriteria;
import com.innowise.dude_where_is_my_car.dto.responses.AnnouncementResponse;
import com.innowise.dude_where_is_my_car.exceptions.ResourceNotFoundException;
import com.innowise.dude_where_is_my_car.external.feign.CurrencyClient;
import com.innowise.dude_where_is_my_car.external.feign.dto.CurrencyName;
import com.innowise.dude_where_is_my_car.external.feign.dto.CurrencyRateRequest;
import com.innowise.dude_where_is_my_car.external.feign.dto.CurrencyRateResponse;
import com.innowise.dude_where_is_my_car.models.Announcement;
import com.innowise.dude_where_is_my_car.repositories.AnnouncementRepository;
import com.innowise.dude_where_is_my_car.repositories.AnnouncementSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private final AnnouncementSearchRepository announcementSearchRepository;
    private final CurrencyClient currencyClient;


    public Announcement saveAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }


    public Announcement getById(Long id) {
        return announcementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("announcement with id " + id + " not found"));
    }


    public List<Announcement> searchAnnouncement(SearchAnnouncementRequest searchAnnouncementRequest, PageCriteria pageCriteria, SortingCriteria sortingCriteria) {
        return announcementSearchRepository.search(searchAnnouncementRequest, pageCriteria, sortingCriteria);
    }


    public Announcement deleteAnnouncement(Long id) {
        Announcement announcement = getById(id);
        announcement.setIsDeleted(true);
        return announcementRepository.save(announcement);
    }


    public List<AnnouncementResponse> convertAnnouncementPrice(List<AnnouncementResponse> announcements, String from, String to) {
        CurrencyRateRequest rateRequest = new CurrencyRateRequest();
        rateRequest.setBaseCurrency(CurrencyName.valueOf(from.toUpperCase()));
        rateRequest.setRateRequests(List.of(CurrencyName.valueOf(to.toUpperCase())));

        CurrencyRateResponse rateResponse = currencyClient.getCurrencyRate(rateRequest.getBaseCurrency(), rateRequest.getRateRequests());
        Float rate = rateResponse.getRates().get(CurrencyName.valueOf(to.toUpperCase()));
        return announcements.stream()
                .map(a -> new AnnouncementResponse(
                        a.getAnnouncementId(),
                        a.getVehicle(),
                        a.getPrice() * rate,
                        to,
                        a.getComment()))
                .toList();
    }
}

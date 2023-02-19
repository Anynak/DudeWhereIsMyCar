package com.innowise.DudeWhereIsMyCar.controllers;

import com.innowise.DudeWhereIsMyCar.Const.Const;
import com.innowise.DudeWhereIsMyCar.DTO.mapers.AnnouncementMapper;
import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.AnnouncementRequest;
import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.searchCriteria.SearchAnnouncementRequest;
import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.searchCriteria.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.DTO.responceDTO.AnnouncementResponse;
import com.innowise.DudeWhereIsMyCar.model.Announcement;
import com.innowise.DudeWhereIsMyCar.model.User;
import com.innowise.DudeWhereIsMyCar.service.AnnouncementService;
import com.innowise.DudeWhereIsMyCar.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/announcements")
@Validated
public class AnnouncementController {

    private final AnnouncementService announcementService;
    private final AnnouncementMapper announcementMapper;
    private final UserService userService;

    @PostMapping("/v1")
    public ResponseEntity<AnnouncementResponse> addAnnouncementController(@RequestBody @Valid AnnouncementRequest announcementRequest, Principal principal) {
        Announcement announcement = announcementMapper.toAnnouncement(announcementRequest);
        User user = userService.findUserBuLogin(principal.getName());
        announcement.setUser(user);
        AnnouncementResponse response = announcementMapper.toAnnouncementResponse(announcementService.saveAnnouncement(announcement));
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping("/v1")
    public List<AnnouncementResponse> findAnnouncement(
            @RequestParam(required = false) @Size(min = 3, max = 3) String currency,
            @Valid SearchAnnouncementRequest searchAnnouncementRequest,
            @Valid PageCriteria pageCriteria,
            @Valid SortingCriteria sortingCriteria) {

        List<Announcement> announcements = announcementService.searchAnnouncement(searchAnnouncementRequest, pageCriteria, sortingCriteria);
        List<AnnouncementResponse> responses = announcementMapper.toAnnouncementResponse(announcements);
        if (currency != null) {
            responses = announcementService.convertAnnouncementPrice(responses, Const.defaultCurrency, currency);
        }
        return responses;
    }

    @DeleteMapping("/v1/{id}")
    public AnnouncementResponse deleteAnnouncementController(@PathVariable @Valid Long id) {
        Announcement deletedAnnouncement = announcementService.deleteAnnouncement(id);
        return announcementMapper.toAnnouncementResponse(deletedAnnouncement);

    }
}

package com.innowise.dude_where_is_my_car.controllers;

import com.innowise.dude_where_is_my_car.configs.Constants;
import com.innowise.dude_where_is_my_car.dto.mapers.AnnouncementMapper;
import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.PageCriteria;
import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.SearchAnnouncementRequest;
import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.SortingCriteria;
import com.innowise.dude_where_is_my_car.dto.requests.user_requests.AnnouncementRequest;
import com.innowise.dude_where_is_my_car.dto.responses.AnnouncementResponse;
import com.innowise.dude_where_is_my_car.models.Announcement;
import com.innowise.dude_where_is_my_car.models.User;
import com.innowise.dude_where_is_my_car.service.AnnouncementService;
import com.innowise.dude_where_is_my_car.service.QAnnouncementService;
import com.innowise.dude_where_is_my_car.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
@SecurityRequirement(name = "bearerAuth")
public class AnnouncementController {

    private final AnnouncementService announcementService;
    private final QAnnouncementService qAnnouncementService;
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

        List<Announcement> announcements = qAnnouncementService.searchAnnouncement(searchAnnouncementRequest, pageCriteria, sortingCriteria);
        List<AnnouncementResponse> responses = announcementMapper.toAnnouncementResponse(announcements);
        if (currency != null) {
            responses = announcementService.convertAnnouncementPrice(responses, Constants.DEFAULT_CURRENCY, currency);
        }
        return responses;
    }

    @DeleteMapping("/v1/{id}")
    public AnnouncementResponse deleteAnnouncementController(@PathVariable @Valid Long id) {
        Announcement deletedAnnouncement = announcementService.deleteAnnouncement(id);
        return announcementMapper.toAnnouncementResponse(deletedAnnouncement);

    }
}

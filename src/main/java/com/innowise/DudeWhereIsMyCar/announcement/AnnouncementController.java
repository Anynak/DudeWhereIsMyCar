package com.innowise.DudeWhereIsMyCar.announcement;

import com.innowise.DudeWhereIsMyCar.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.searchCriteria.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.user.User;
import com.innowise.DudeWhereIsMyCar.user.UserService;
import jakarta.validation.Valid;
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
@RequestMapping("/api")
@Validated
public class AnnouncementController {

    private final AnnouncementService announcementService;
    private final AnnouncementMapper announcementMapper;
    private final UserService userService;

    @PostMapping("/announcement")
    public ResponseEntity<AnnouncementResponse> addAnnouncementController(@RequestBody @Valid AnnouncementRequest announcementRequest, Principal principal) {
        Announcement announcement = announcementMapper.toAnnouncement(announcementRequest);
        User user = userService.findUserBuLogin(principal.getName());
        announcement.setUser(user);
        AnnouncementResponse response = announcementMapper.toAnnouncementResponse(announcementService.saveAnnouncement(announcement));
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping("/announcements")
    public ResponseEntity<List<AnnouncementResponse>> findAnnouncement(
            @Valid SearchAnnouncementRequest searchAnnouncementRequest,
            @Valid PageCriteria pageCriteria,
            @Valid SortingCriteria sortingCriteria) {

        List<Announcement> announcements = announcementService.searchAnnouncement(searchAnnouncementRequest, pageCriteria, sortingCriteria);
        return new ResponseEntity<>(announcementMapper.toAnnouncementResponse(announcements), HttpStatus.OK);
    }

    @DeleteMapping("/announcement/{id}")
    public ResponseEntity<AnnouncementResponse> deleteAnnouncementController(@PathVariable @Valid Long id) {
        Announcement deletedAnnouncement = announcementService.deleteAnnouncement(id);
        return new ResponseEntity<>(announcementMapper.toAnnouncementResponse(deletedAnnouncement), HttpStatus.OK);

    }
}

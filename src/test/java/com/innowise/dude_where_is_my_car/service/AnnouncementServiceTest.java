package com.innowise.dude_where_is_my_car.service;

import com.innowise.dude_where_is_my_car.models.Announcement;
import com.innowise.dude_where_is_my_car.repositories.AnnouncementRepository;
import com.innowise.dude_where_is_my_car.service.impl.AnnouncementServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
public class AnnouncementServiceTest {
    @Mock
    private AnnouncementRepository announcementRepository;
    @InjectMocks
    private AnnouncementServiceImpl announcementService;

    @Test
    public void checkThatAnnouncementRemovalIsSoft() {
        Announcement announcement = new Announcement();
        boolean isDeleted = false;
        announcement.setIsDeleted(isDeleted);
        Optional<Announcement> opt = Optional.of(announcement);
        Mockito.when(announcementRepository.findById(anyLong())).thenReturn(opt);


        Mockito.when(announcementRepository.save(any(Announcement.class))).thenAnswer(i -> {
            Announcement savingAnnouncement = i.getArgument(0);
            Assertions.assertNotNull(savingAnnouncement);
            Assertions.assertNotEquals(isDeleted, savingAnnouncement.getIsDeleted());
            return null;
        });

        announcementService.deleteAnnouncement(1L);

    }
}

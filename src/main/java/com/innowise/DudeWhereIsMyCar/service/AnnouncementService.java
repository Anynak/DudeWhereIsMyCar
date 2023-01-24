package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.entity.Announcement;

public interface AnnouncementService {
    Announcement saveAnnouncement(Announcement announcement);
    Announcement getById(Long id);
}

package com.innowise.DudeWhereIsMyCar.repositories;

import com.innowise.DudeWhereIsMyCar.models.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}

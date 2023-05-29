package com.innowise.dude_where_is_my_car.repositories;

import com.innowise.dude_where_is_my_car.models.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}

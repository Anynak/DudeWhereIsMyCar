package com.innowise.DudeWhereIsMyCar.announcement;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnnouncementMapper {
    Announcement toAnnouncement(AnnouncementRequest announcementRequest);
    List<AnnouncementResponse> toAnnouncementResponse(List<Announcement> announcementRequest);
    AnnouncementResponse toAnnouncementResponse(Announcement announcement);

}

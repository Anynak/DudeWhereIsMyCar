package com.innowise.DudeWhereIsMyCar.dto.mapers;

import com.innowise.DudeWhereIsMyCar.dto.requests.AnnouncementRequest;
import com.innowise.DudeWhereIsMyCar.dto.responses.AnnouncementResponse;
import com.innowise.DudeWhereIsMyCar.models.Announcement;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnnouncementMapper {
    Announcement toAnnouncement(AnnouncementRequest announcementRequest);

    List<AnnouncementResponse> toAnnouncementResponse(List<Announcement> announcementRequest);

    AnnouncementResponse toAnnouncementResponse(Announcement announcement);

}

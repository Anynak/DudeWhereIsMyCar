package com.innowise.DudeWhereIsMyCar.DTO.mapers;

import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.AnnouncementRequest;
import com.innowise.DudeWhereIsMyCar.DTO.responceDTO.AnnouncementResponse;
import com.innowise.DudeWhereIsMyCar.model.Announcement;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnnouncementMapper {
    Announcement toAnnouncement(AnnouncementRequest announcementRequest);

    List<AnnouncementResponse> toAnnouncementResponse(List<Announcement> announcementRequest);

    AnnouncementResponse toAnnouncementResponse(Announcement announcement);

}

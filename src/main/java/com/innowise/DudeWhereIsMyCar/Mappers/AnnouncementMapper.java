package com.innowise.DudeWhereIsMyCar.Mappers;

import com.innowise.DudeWhereIsMyCar.dto.request.AnnouncementRequest;
import com.innowise.DudeWhereIsMyCar.dto.response.AnnouncementResponse;
import com.innowise.DudeWhereIsMyCar.entity.Announcement;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnnouncementMapper {
    Announcement toAnnouncement(AnnouncementRequest announcementRequest);
    List<AnnouncementResponse> toAnnouncementResponse(List<Announcement> announcementRequest);
    AnnouncementResponse toAnnouncementResponse(Announcement announcement);

}

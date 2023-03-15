package com.innowise.DudeWhereIsMyCar.dto.mapers;

import com.innowise.DudeWhereIsMyCar.dto.requests.AnnouncementRequest;
import com.innowise.DudeWhereIsMyCar.dto.responses.AnnouncementResponse;
import com.innowise.DudeWhereIsMyCar.models.Announcement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnnouncementMapper {
    @Mapping(target = "announcementId", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    Announcement toAnnouncement(AnnouncementRequest announcementRequest);


    List<AnnouncementResponse> toAnnouncementResponse(List<Announcement> announcementRequest);
    @Mapping(target = "currency", ignore = true)
    AnnouncementResponse toAnnouncementResponse(Announcement announcement);

}

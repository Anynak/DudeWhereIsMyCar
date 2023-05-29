package com.innowise.dude_where_is_my_car.dto.mapers;

import com.innowise.dude_where_is_my_car.dto.requests.user_requests.AnnouncementRequest;
import com.innowise.dude_where_is_my_car.dto.responses.AnnouncementResponse;
import com.innowise.dude_where_is_my_car.models.Announcement;
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

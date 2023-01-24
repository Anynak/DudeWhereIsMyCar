package com.innowise.DudeWhereIsMyCar.dto.response;

import lombok.Data;

@Data
public class AnnouncementResponse {
    private Long announcementId;
    private VehicleResponse vehicle;
    private Float price;
    private String comment;
}

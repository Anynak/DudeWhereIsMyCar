package com.innowise.DudeWhereIsMyCar.DTO.responceDTO;

import lombok.Data;

@Data
public class AnnouncementResponse {
    private Long announcementId;
    private VehicleResponse vehicle;
    private Float price;
    private String comment;
}

package com.innowise.DudeWhereIsMyCar.dto.response;

import lombok.Data;

@Data
public class AnnouncementResponse {
    private VehicleResponse vehicle;
    private Float price;
    private String comment;
}

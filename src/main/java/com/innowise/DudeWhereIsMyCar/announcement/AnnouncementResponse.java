package com.innowise.DudeWhereIsMyCar.announcement;

import com.innowise.DudeWhereIsMyCar.vehicle.VehicleResponse;
import lombok.Data;

@Data
public class AnnouncementResponse {
    private Long announcementId;
    private VehicleResponse vehicle;
    private Float price;
    private String comment;
}

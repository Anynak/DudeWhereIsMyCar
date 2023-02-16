package com.innowise.DudeWhereIsMyCar.DTO.responceDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnnouncementResponse {
    private Long announcementId;
    private VehicleResponse vehicle;
    private Float price;
    private String comment;
}

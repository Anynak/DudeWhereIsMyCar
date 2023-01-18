package com.innowise.DudeWhereIsMyCar.dto.response;

import com.innowise.DudeWhereIsMyCar.entity.Vehicle;
import lombok.Data;

@Data
public class AnnouncementResponse {
    private Vehicle vehicle;
    private Float price;
    private String comment;
}

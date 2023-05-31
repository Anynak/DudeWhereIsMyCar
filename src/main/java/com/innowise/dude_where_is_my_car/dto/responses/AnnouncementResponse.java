package com.innowise.dude_where_is_my_car.dto.responses;

import com.innowise.dude_where_is_my_car.configs.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementResponse {
    private Long announcementId;
    private VehicleResponse vehicle;
    private Float price;
    private String currency = Constants.DEFAULT_CURRENCY;
    private String comment;
}

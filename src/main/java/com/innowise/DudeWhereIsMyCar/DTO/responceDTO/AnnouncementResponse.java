package com.innowise.DudeWhereIsMyCar.DTO.responceDTO;

import com.innowise.DudeWhereIsMyCar.Const.Const;
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
    private String currency = Const.defaultCurrency;
    private String comment;
}

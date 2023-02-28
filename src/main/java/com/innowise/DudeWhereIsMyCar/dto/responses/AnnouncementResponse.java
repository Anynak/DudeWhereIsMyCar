package com.innowise.DudeWhereIsMyCar.dto.responses;

import com.innowise.DudeWhereIsMyCar.configs.consts.Const;
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

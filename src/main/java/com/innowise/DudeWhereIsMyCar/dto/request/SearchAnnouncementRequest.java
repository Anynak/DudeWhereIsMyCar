package com.innowise.DudeWhereIsMyCar.dto.request;

import com.innowise.DudeWhereIsMyCar.Const.Const;
import lombok.Data;

@Data
public class SearchAnnouncementRequest {

    private Float priceMin = 0f;
    private Float priceMax = Const.MAX_PRICE;
    private Integer mileageMin = 0;
    private Integer mileageMax = Const.MAX_MILEAGE;
    private Integer releaseYearMin = Const.MIN_RELEASE_YEAR;
    private Integer releaseYearMax = Const.getMaxReleaseYear();
    private String color;
    private String vehicleTypeName;
    private String vehicleBrandName;
    private String vehicleModelName;

}
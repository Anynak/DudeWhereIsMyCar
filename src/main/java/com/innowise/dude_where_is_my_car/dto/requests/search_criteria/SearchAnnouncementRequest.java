package com.innowise.dude_where_is_my_car.dto.requests.search_criteria;


import com.innowise.dude_where_is_my_car.configs.consts.Const;
import lombok.Data;

@Data
public class SearchAnnouncementRequest {

    private Float priceMin = Const.MIN_PRICE;
    private Float priceMax = Const.MAX_PRICE;
    private Integer mileageMin = Const.MIN_MILEAGE;
    private Integer mileageMax = Const.MAX_MILEAGE;
    private Integer releaseYearMin = Const.MIN_RELEASE_YEAR;
    private Integer releaseYearMax = Const.MAX_RELEASE_YEAR;
    private String color;
    private String vehicleBrandName;
    private String vehicleModelName;

}

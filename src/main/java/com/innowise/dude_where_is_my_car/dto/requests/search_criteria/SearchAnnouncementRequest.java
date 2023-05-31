package com.innowise.dude_where_is_my_car.dto.requests.search_criteria;


import com.innowise.dude_where_is_my_car.configs.Constants;
import lombok.Data;

@Data
public class SearchAnnouncementRequest {

    private Float priceMin = Constants.MIN_PRICE;
    private Float priceMax = Constants.MAX_PRICE;
    private Integer mileageMin = Constants.MIN_MILEAGE;
    private Integer mileageMax = Constants.MAX_MILEAGE;
    private Integer releaseYearMin = Constants.MIN_RELEASE_YEAR;
    private Integer releaseYearMax = Constants.MAX_RELEASE_YEAR;
    private String color;
    private String vehicleBrandName;
    private String vehicleModelName;

}

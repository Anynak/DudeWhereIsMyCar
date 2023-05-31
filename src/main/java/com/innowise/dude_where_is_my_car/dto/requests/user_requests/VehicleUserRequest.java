package com.innowise.dude_where_is_my_car.dto.requests.user_requests;

import com.innowise.dude_where_is_my_car.configs.Constants;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VehicleUserRequest {


    @Max(Constants.MAX_MILEAGE)
    @Min(0)
    private Integer mileage = 0;
    @NotNull
    @Min(Constants.MIN_RELEASE_YEAR)
    @Max(Constants.MAX_RELEASE_YEAR)
    private Integer releaseYear;
    @NotNull
    @NotBlank
    private String color;
    @Valid
    @NotNull
    private VehicleModelUserRequest vehicleModel;
}

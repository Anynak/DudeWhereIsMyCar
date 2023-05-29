package com.innowise.dude_where_is_my_car.dto.requests;

import com.innowise.dude_where_is_my_car.configs.consts.Const;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VehicleRequest {
    private Long vehicleId;

    @Max(Const.MAX_MILEAGE)
    @Min(0)
    private Integer mileage = 0;

    @NotNull
    @Min(Const.MIN_RELEASE_YEAR)
    private Integer releaseYear;

    @NotNull
    @NotBlank
    private String color;
    @Valid
    @NotNull
    private VehicleModelRequest vehicleModel;

}

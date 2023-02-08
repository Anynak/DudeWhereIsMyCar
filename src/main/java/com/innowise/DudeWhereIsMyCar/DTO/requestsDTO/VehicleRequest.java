package com.innowise.DudeWhereIsMyCar.DTO.requestsDTO;

import com.innowise.DudeWhereIsMyCar.Const.Const;
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

    @NotNull
    private VehicleTypeRequest vehicleType;

    @NotNull
    private VehicleModelRequest vehicleModel;

}

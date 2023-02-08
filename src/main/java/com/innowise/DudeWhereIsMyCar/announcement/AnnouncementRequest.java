package com.innowise.DudeWhereIsMyCar.announcement;

import com.innowise.DudeWhereIsMyCar.vehicle.VehicleRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnnouncementRequest {

    @NotNull
    private VehicleRequest vehicle;

    @NotNull
    @Min(value = 0)
    private Float price;

    @NotNull
    @NotBlank
    private String comment;
}

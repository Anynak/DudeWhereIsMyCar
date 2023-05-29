package com.innowise.dude_where_is_my_car.dto.requests.user_requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnnouncementRequest {
    @Valid
    @NotNull
    private VehicleUserRequest vehicle;

    @NotNull
    @Min(value = 0)
    private Float price;

    @NotNull
    @NotBlank
    private String comment;
}

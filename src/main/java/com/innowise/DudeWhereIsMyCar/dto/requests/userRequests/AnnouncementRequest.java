package com.innowise.DudeWhereIsMyCar.dto.requests.userRequests;

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

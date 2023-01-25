package com.innowise.DudeWhereIsMyCar.dto.request;

import lombok.Data;

@Data
public class SearchAnnouncementRequest {
    private Float minPrice = 0f;
    private Float maxPrice = 0f;
}

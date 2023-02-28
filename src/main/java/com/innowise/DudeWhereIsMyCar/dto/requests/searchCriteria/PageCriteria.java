package com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria;

import com.innowise.DudeWhereIsMyCar.configs.consts.Const;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class PageCriteria {
    @Min(value = 1)
    private int pageNumber = Const.MIN_PAGE_NUMBER;

    @Min(value = 1)
    @Max(value = 100)
    private int pageSize = Const.MIN_PAGE_SIZE;

}

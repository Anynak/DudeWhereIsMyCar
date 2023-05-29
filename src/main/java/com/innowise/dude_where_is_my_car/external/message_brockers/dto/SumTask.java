package com.innowise.dude_where_is_my_car.external.message_brockers.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SumTask {

    private Long n1;
    private Long n2;
    private Long sum;

    public SumTask(Long n1, Long n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
}
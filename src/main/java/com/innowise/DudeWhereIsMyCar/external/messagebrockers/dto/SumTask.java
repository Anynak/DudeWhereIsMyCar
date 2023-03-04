package com.innowise.DudeWhereIsMyCar.external.messagebrockers.dto;

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

package com.innowise.DudeWhereIsMyCar.service.impl;

import com.innowise.DudeWhereIsMyCar.service.PrintService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
@RequiredArgsConstructor
public class SchedulingService {
    private final PrintService printService;

    @Scheduled(initialDelayString = "${schedulerPrint.initialDelayMs}", fixedDelayString = "${schedulerPrint.intervalMs}")
    private void print(){
        printService.print();
    }

}

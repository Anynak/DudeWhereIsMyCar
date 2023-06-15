package com.innowise.dude_where_is_my_car.service;


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
    private void print() {
        printService.print();
    }

}

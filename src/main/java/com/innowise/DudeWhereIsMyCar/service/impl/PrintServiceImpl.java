package com.innowise.DudeWhereIsMyCar.service.impl;

import com.innowise.DudeWhereIsMyCar.service.PrintService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PrintServiceImpl implements PrintService {

    @Override
    public void print() {
        System.out.println("app is working");
    }
}

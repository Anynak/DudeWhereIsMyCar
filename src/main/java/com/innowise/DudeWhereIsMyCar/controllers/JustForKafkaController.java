package com.innowise.DudeWhereIsMyCar.controllers;

import com.innowise.DudeWhereIsMyCar.dto.messageBrocker.SumTask;
import com.innowise.DudeWhereIsMyCar.service.messageBroker.currentService.CurrentProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/sum")
public class JustForKafkaController {
    private final CurrentProducer currentProducer;

    @PostMapping("/{n1}/{n2}")
    public ResponseEntity<?> registerUser(@PathVariable Long n1, @PathVariable Long n2) {
        SumTask sumTask = new SumTask(n1, n2);
        currentProducer.sendMessageToTopic(sumTask);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

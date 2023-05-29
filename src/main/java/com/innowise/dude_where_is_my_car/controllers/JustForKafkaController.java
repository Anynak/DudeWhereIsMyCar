package com.innowise.dude_where_is_my_car.controllers;

import com.innowise.dude_where_is_my_car.external.message_brockers.dto.SumTask;
import com.innowise.dude_where_is_my_car.external.message_brockers.kafka.current.service.CurrentProducer;
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

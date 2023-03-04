package com.innowise.DudeWhereIsMyCar.external.messagebrockers.kafka.current.service;

import com.innowise.DudeWhereIsMyCar.external.messagebrockers.dto.SumTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CurrentProducer {
    @Autowired
    @Qualifier("currentKafkaTemplate")
    private KafkaTemplate<String, SumTask> kafkaTemplate;

    public void sendMessageToTopic(SumTask sumTask) {
        kafkaTemplate.send("in", sumTask);
    }
}

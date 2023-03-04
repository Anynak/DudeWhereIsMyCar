package com.innowise.DudeWhereIsMyCar.external.messagebrockers.kafka.adder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AdderProducer {

    @Autowired
    @Qualifier("adderKafkaTemplate")
    private KafkaTemplate<String, Long> kafkaTemplate;

    public void sendMessageToTopic(Long sum) {
        kafkaTemplate.send("out", sum);
    }
}

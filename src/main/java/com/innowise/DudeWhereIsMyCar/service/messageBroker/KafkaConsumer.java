package com.innowise.DudeWhereIsMyCar.service.messageBroker;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "SomeTopic", groupId = "some-group")
    public void listenToCodeDecodeKafkaTopic(String messageReceived) {
        System.out.println("Message received is " + messageReceived);
    }
}

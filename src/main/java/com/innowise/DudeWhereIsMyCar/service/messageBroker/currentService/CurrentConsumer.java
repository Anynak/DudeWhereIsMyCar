package com.innowise.DudeWhereIsMyCar.service.messageBroker.currentService;

import com.innowise.DudeWhereIsMyCar.dto.messageBrocker.SumTask;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//https://medium.com/event-driven-utopia/understanding-kafka-topic-partitions-ae40f80552e8
@Service
public class CurrentConsumer {
    @KafkaListener(topics = "out", groupId = "autoShop_1")
    public void listenToKafkaTopic(SumTask sumTask) {
        System.out.println("Message received is " + sumTask);
    }
}

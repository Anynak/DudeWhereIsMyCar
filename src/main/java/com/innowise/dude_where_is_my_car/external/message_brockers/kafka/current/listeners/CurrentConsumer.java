package com.innowise.dude_where_is_my_car.external.message_brockers.kafka.current.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//https://medium.com/event-driven-utopia/understanding-kafka-topic-partitions-ae40f80552e8
@Service
public class CurrentConsumer {
    @KafkaListener(topics = "out",
            groupId = "autoShop_1",
            containerFactory = "adderKafkaListenerContainerFactory")
    public void listenToKafkaTopic(Long sum) {
        System.out.println("Message received is " + sum);
    }
}

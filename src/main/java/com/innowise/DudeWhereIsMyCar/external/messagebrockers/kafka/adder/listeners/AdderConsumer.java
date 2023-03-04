package com.innowise.DudeWhereIsMyCar.external.messagebrockers.kafka.adder.listeners;

import com.innowise.DudeWhereIsMyCar.external.messagebrockers.dto.SumTask;
import com.innowise.DudeWhereIsMyCar.external.messagebrockers.kafka.adder.service.AdderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//https://medium.com/event-driven-utopia/understanding-kafka-topic-partitions-ae40f80552e8
@Service
@RequiredArgsConstructor
public class AdderConsumer {

    private final AdderProducer adderProducer;

    @KafkaListener(topics = "in", groupId = "adder_1", containerFactory = "currentKafkaListenerContainerFactory")
    public void listenToKafkaTopic(SumTask sumTask) {
        sumTask.setSum(sumTask.getN1() + sumTask.getN2());
        adderProducer.sendMessageToTopic(sumTask.getN1() + sumTask.getN2());
    }
}

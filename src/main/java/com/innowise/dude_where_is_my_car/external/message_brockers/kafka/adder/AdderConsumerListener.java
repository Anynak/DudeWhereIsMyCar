package com.innowise.dude_where_is_my_car.external.message_brockers.kafka.adder;

import com.innowise.dude_where_is_my_car.external.message_brockers.SumTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//https://medium.com/event-driven-utopia/understanding-kafka-topic-partitions-ae40f80552e8
@Service
@RequiredArgsConstructor
public class AdderConsumerListener {

    private final AdderProducerService adderProducer;

    @KafkaListener(topics = "in", groupId = "adder_1", containerFactory = "currentKafkaListenerContainerFactory")
    public void listenToKafkaTopic(SumTaskDto sumTask) {
        sumTask.setSum(sumTask.getN1() + sumTask.getN2());
        adderProducer.sendMessageToTopic(sumTask.getN1() + sumTask.getN2());
    }
}

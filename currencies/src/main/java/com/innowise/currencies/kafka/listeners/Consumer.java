//package com.innowise.currencies.kafka.listeners;
//
//import com.innowise.currencies.dto.CurrencyRateRequest;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class Consumer {
//    @KafkaListener(topics = "currencyOut",
//            groupId = "autoShop_1",
//            containerFactory = "adderKafkaListenerContainerFactory")
//    public void listenToKafkaTopic(CurrencyRateRequest currencyRateRequest) {
//        System.out.println("Message received is " + currencyRateRequest);
//    }
//
//}

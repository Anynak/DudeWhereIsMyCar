//package com.innowise.currencies.kafka.services;
//
//import com.innowise.currencies.dto.CurrencyRateResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class Producer {
//    @Autowired
//    private KafkaTemplate<String, CurrencyRateResponse> kafkaTemplate;
//
//    public void sendMessageToTopic(CurrencyRateResponse currencyRateResponse) {
//        kafkaTemplate.send("currencyIn", currencyRateResponse);
//    }
//}

package com.kafka.app.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(topics = "TEST-TOPIC", groupId = "CONSUMER_GROUP_ID")
    public String readKafkaMessage(String message){
        try{
            log.info("Consuming message from kafka, Message = {}",message);
            return "Consuming message = "+message;
        }catch (Exception exception){
            log.error("Exception while consuming message {}", exception);
            return "Exception while consuming message";
        }
    }
}

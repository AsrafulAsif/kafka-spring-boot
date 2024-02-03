package com.example.kafkaproducer.service;

import com.example.kafkaproducer.model.EventRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String,String> kafkaStringTemplate;
    private final KafkaTemplate<String, EventRequest> kafkaJsonTemplate;

    public KafkaProducerService(KafkaTemplate<String, EventRequest> kafkaJsonTemplate, KafkaTemplate<String, String> kafkaStringTemplate) {
        this.kafkaJsonTemplate = kafkaJsonTemplate;
        this.kafkaStringTemplate = kafkaStringTemplate;
    }

    public void sendStringData(String topic,String message){
        kafkaStringTemplate.send(topic,message);
    }

    public void sendJsonData(String topic, EventRequest request){
        kafkaJsonTemplate.send(topic,request);
    }
}

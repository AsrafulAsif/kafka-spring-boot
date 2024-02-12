package com.example.kafkaproducer.service;

import com.example.kafkaproducer.model.EventRequest;
import com.example.kafkaproducer.util.ConvertingObjectStringObject;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String,String> kafkaStringTemplate;
    private final KafkaTemplate<String, Object> kafkaJsonTemplate;

    public KafkaProducerService(KafkaTemplate<String, Object> kafkaJsonTemplate, KafkaTemplate<String, String> kafkaStringTemplate) {
        this.kafkaJsonTemplate = kafkaJsonTemplate;
        this.kafkaStringTemplate = kafkaStringTemplate;
    }

    public void sendStringData(String topic,String message){
        kafkaStringTemplate.send(topic,message);
    }

    public void sendJsonData(String topic, Object request){
        kafkaJsonTemplate.send(topic,request);
    }

    public <U> void sendData(String topic,U request){
        String stringData = ConvertingObjectStringObject.convertObjectToString(request);
        kafkaStringTemplate.send(topic,stringData);
    }
}

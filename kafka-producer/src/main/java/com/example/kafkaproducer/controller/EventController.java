package com.example.kafkaproducer.controller;


import com.example.kafkaproducer.model.EventRequest;
import com.example.kafkaproducer.service.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/event")
public class EventController{
    private final KafkaProducerService kafkaProducerService;

    public EventController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }


    @PostMapping("/message")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sendEventString( @RequestParam(value = "message") String message) {
        kafkaProducerService.sendStringData("event-topic-message", message);
        log.info("Data send to the kafka........");
    }


    @PostMapping("/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sendEventObject(@RequestBody EventRequest request) {
        kafkaProducerService.sendJsonData("event-topic-json", request);
        log.info("Json Data send to the kafka........");
    }

}

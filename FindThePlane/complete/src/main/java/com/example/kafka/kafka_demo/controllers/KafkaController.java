package com.example.kafka.kafka_demo.controllers;

import com.example.kafka.kafka_demo.services.ProducerClass;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")
public class KafkaController {

    private final ProducerClass producer;

    public KafkaController(ProducerClass producer) {
        this.producer = producer;
    }

    @PostMapping(value="/publish")
    public String sendMessage(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
        return "Published successfully";
    }


    @GetMapping(value="/receive")
    public String getMessage(String message) {
        this.producer.sendMessage(message);
        return message;
    }


    @Bean
    public NewTopic adviceTopic() {
        return new NewTopic("user", 3, (short)1);
    }
}

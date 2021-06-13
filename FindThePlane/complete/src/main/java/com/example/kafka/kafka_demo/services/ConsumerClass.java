package com.example.kafka.kafka_demo.services;

import java.io.*;
import java.net.*;

import com.example.kafka.kafka_demo.model.FlightsRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class ConsumerClass {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerClass.class);

    @Autowired
	  private FlightsRepository flight_repository;

    @KafkaListener(topics = "user", groupId = "group-1")
    public void consume(String message) {
        if (message.equals("\"delete\"")) {
          flight_repository.deleteAll();
        }
        if(message != null) {

          Double lon = -100.0;
          Double lat = 0.0;
          Double alt = -1.0;

          message = message.substring(1, message.length() - 1);
          String[] parameters = message.split(",");

          try {
              lon = Double.parseDouble(parameters[5]);
              lat = Double.parseDouble(parameters[6]);
              alt = Double.parseDouble(parameters[13]);

              Flight f1 = new Flight(parameters[0].replaceAll("\"",""), parameters[2].replaceAll("\"",""), lon, lat, alt);
              logger.info(String.format("--> %s", f1));
              flight_repository.save(f1);


          } catch (Exception e) {
          }
        }
    }
}

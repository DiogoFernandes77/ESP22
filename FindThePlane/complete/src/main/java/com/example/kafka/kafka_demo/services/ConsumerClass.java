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

    @KafkaListener(topics = "user")
    public void consume(String message) {
        if (message.equals("\"delete\"")) {
          try {
            System.out.println("\n\n\n\nENTRA");
            File file = new File("myJson.json");
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
          } catch(IOException e) {
              e.printStackTrace();
          }
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
              if (alt < 500) {
                Flight f1 = new Flight(parameters[0].replaceAll("\"",""), parameters[2].replaceAll("\"",""), lon, lat, alt);
                logger.info(String.format("--> %s", f1));

                String line;
                File file = new File("myJson.json");
                BufferedReader br = new BufferedReader(new FileReader(file));

                try(FileWriter fw = new FileWriter("myJson.json", true)) {

                    flight_repository.save(f1);
                    fw.write(f1.toJsonLow() + "\n");
                    fw.flush();

                } catch(IOException e) {
                    e.printStackTrace();
                }
              }
              if (alt > 2000) {
                Flight f1 = new Flight(parameters[0].replaceAll("\"",""), parameters[2].replaceAll("\"",""), lon, lat, alt);
                logger.info(String.format("--> %s", f1));

                String line;
                File file = new File("myJson.json");
                BufferedReader br = new BufferedReader(new FileReader(file));

                try(FileWriter fw = new FileWriter("myJson.json", true)) {

                    fw.write(f1.toJsonHigh() + "\n");
                    fw.flush();

                } catch(IOException e) {
                    e.printStackTrace();
                }
              }

          } catch (Exception e) {
          }




        }

    }

}

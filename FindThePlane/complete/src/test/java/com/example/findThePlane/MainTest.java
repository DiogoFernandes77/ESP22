package com.example.findThePlane;

import com.example.kafka.kafka_demo.FlightController;
import com.example.kafka.kafka_demo.KafkaDemoApplication;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest(classes = KafkaDemoApplication.class)
class MainTest {

    @Autowired
    private FlightController controller;
    
    @Autowired
	private MockMvc mockMvc;
    
    
    @Test
    void contextLoads() {
        
        System.out.println("Controller exists");
        assertNotNull(controller);   
    
    }









}

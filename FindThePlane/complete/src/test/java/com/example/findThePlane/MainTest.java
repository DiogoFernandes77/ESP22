package com.example.findThePlane;

import com.example.kafka.kafka_demo.FlightController;
import com.example.kafka.kafka_demo.KafkaDemoApplication;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    @Test
   public void requestIndex() throws Exception {
       System.out.println("Request index");
       fakmfqk
       this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
   }
    @Test
   public void requestMap() throws Exception {
       System.out.println("Request map");
       this.mockMvc.perform(get("/map")).andDo(print()).andExpect(status().isOk());
   }
   @Test
   public void requestLow() throws Exception {
       System.out.println("Request lowflights");
       this.mockMvc.perform(get("/lowflights")).andDo(print()).andExpect(status().isOk());
   }
   @Test
   public void requestHigh() throws Exception {
       System.out.println("Request highflights");
       this.mockMvc.perform(get("/highflights")).andDo(print()).andExpect(status().isOk());
   }
   @Test
   public void requestFlights() throws Exception {
       System.out.println("Request flights");
       this.mockMvc.perform(get("/flights")).andDo(print()).andExpect(status().isOk());
   }







}

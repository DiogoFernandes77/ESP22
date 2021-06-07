package com.example.kafka.kafka_demo.model;

import com.example.kafka.kafka_demo.services.Flight;

import org.springframework.data.repository.CrudRepository;




// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface FlightsRepository extends CrudRepository<Flight, String> {



}
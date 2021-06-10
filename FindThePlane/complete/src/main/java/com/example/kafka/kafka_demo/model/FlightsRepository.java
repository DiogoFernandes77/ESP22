package com.example.kafka.kafka_demo.model;

import java.util.*;
import com.example.kafka.kafka_demo.services.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;




// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface FlightsRepository extends CrudRepository<Flight, String> {

  // Low flights
  @Query("SELECT u FROM Flight u WHERE u.altitude < 500")
	Collection<Flight> findAllLowFlights();

  // High flights
  @Query("SELECT u FROM Flight u WHERE u.altitude > 5000")
	Collection<Flight> findAllHighFlights();

}

package com.example.kafka.kafka_demo;

import org.json.*;
import java.io.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.kafka.kafka_demo.services.*;
import com.example.kafka.kafka_demo.model.FlightsRepository;
@Controller
public class FlightController {

	// @GetMapping("/greeting")
	// public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
  //
  //
	// 	model.addAttribute("name", "ola");
	// 	return "greeting";
	// }

	@Autowired
	private FlightsRepository flight_repository;


	@GetMapping("/flights")
	public String flights(@RequestParam(name="name", required=false, defaultValue="idk") String name, Model model) {

		model.addAttribute("name", flight_repository.findAll());
		return "flights";
	}

	@GetMapping("/lowflights")
	public String lowflights(@RequestParam(name="name", required=false, defaultValue="idk") String name, Model model) {

		model.addAttribute("name", flight_repository.findAllLowFlights());
		return "lowflights";
	}

	@GetMapping("/highflights")
	public String highflights(@RequestParam(name="name", required=false, defaultValue="idk") String name, Model model) {

		model.addAttribute("name", flight_repository.findAllHighFlights());
		return "highflights";
	}

	@GetMapping("/map")
	public String history(@RequestParam(name="name", required=false, defaultValue="idk") String name, Model model) {

		ArrayList<Coordinates> coordinates = new ArrayList<Coordinates>();

		for (Flight f : flight_repository.findAll()) {
			double lon = (Double) f.getLon();
			double lat = (Double) f.getLat();
			Coordinates c = new Coordinates(lon, lat);
			coordinates.add(c);
		}

		model.addAttribute("coords", coordinates);
		return "map";
	}

}

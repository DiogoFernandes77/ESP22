package com.example.kafka.kafka_demo;

import java.io.*;
import java.util.*;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FlightController {

	// @GetMapping("/greeting")
	// public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
  //
  //
	// 	model.addAttribute("name", "ola");
	// 	return "greeting";
	// }

	@GetMapping("/flights")
	public String flights(@RequestParam(name="name", required=false, defaultValue="idk") String name, Model model) {

    ArrayList<String> flightsAL = new ArrayList<String>();

    try {
      File f = new File("myJson.json");
      Scanner r = new Scanner(f);
      while (r.hasNextLine()) {
        String data = r.nextLine();
        flightsAL.add(data);
      }
      r.close();
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    String [] flights = new String[flightsAL.size()];

    int i = 0;
    for (String f : flightsAL) {
      flights[i] = f;
      i++;
    }

		model.addAttribute("name", flights);
		return "/flights";
	}

	// @GetMapping("/map")
	// public String history(@RequestParam(name="name", required=false, defaultValue="idk") String name, Model model) {
  //
	// 	ReadJSON js = new ReadJSON();
	// 	ArrayList<Flight> coordList = new ArrayList<Flight>();
	// 	String [] array = js.getFlights();
	// 	for(int i=0; i<array.length; i++){
	// 		String [] info = array[i].split(",");
	// 		double longitude = Double.parseDouble(info[5].toString().trim());
  //   		double latitude = Double.parseDouble(info[6].toString().trim());
	// 		Flight f1 = new Flight(latitude, longitude);
	// 		System.out.print(f1);
	// 		coordList.add(f1);
	// 	}
  //
	// 	model.addAttribute("coords", coordList);
	// 	return "map";
	// }

}

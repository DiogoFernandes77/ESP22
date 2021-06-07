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

	
	
	@GetMapping("/flights")
	public String flights(@RequestParam(name="name", required=false, defaultValue="idk") String name, Model model) {

    ArrayList<Flight> flights = new ArrayList<Flight>();

    try {
      File f = new File("myJson.json");
      Scanner r = new Scanner(f);
			while (r.hasNextLine()) {
        String data = r.nextLine();
				try {
						JSONObject o = new JSONObject(data);
						System.out.println(o);
						String high = (String) o.get("high");
						String id = (String) o.get("id");
						String country = (String) o.get("country");
						double lon = (Double) o.get("lon");
						double lat = (Double) o.get("lat");
						double altitude = (Double) o.get("altitude");
						Flight f1 = new Flight(id, country, lon, lat, altitude);
						flights.add(f1);
				}catch (JSONException err){
     				err.printStackTrace();
				}
      }
      r.close();
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }

		model.addAttribute("name", flights);
		return "flights";
	}

	@GetMapping("/lowflights")
	public String lowflights(@RequestParam(name="name", required=false, defaultValue="idk") String name, Model model) {

    ArrayList<Flight> flights = new ArrayList<Flight>();

    try {
      File f = new File("myJson.json");
      Scanner r = new Scanner(f);
      while (r.hasNextLine()) {
        String data = r.nextLine();
				try {
						JSONObject o = new JSONObject(data);
						System.out.println(o);
						String high = (String) o.get("high");
						String id = (String) o.get("id");
						String country = (String) o.get("country");
						double lon = (Double) o.get("lon");
						double lat = (Double) o.get("lat");
						double altitude = (Double) o.get("altitude");
						Flight f1 = new Flight(id, country, lon, lat, altitude);
						if(high.equals("false"))
								flights.add(f1);
				}catch (JSONException err){
     				err.printStackTrace();
				}
      }
      r.close();
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
		
		model.addAttribute("name", flights);
		return "lowflights";
	}

	@GetMapping("/highflights")
	public String highflights(@RequestParam(name="name", required=false, defaultValue="idk") String name, Model model) {

    ArrayList<Flight> flights = new ArrayList<Flight>();

    try {
      File f = new File("myJson.json");
      Scanner r = new Scanner(f);
      while (r.hasNextLine()) {
        String data = r.nextLine();
				try {
						JSONObject o = new JSONObject(data);
						System.out.println(o);
						String high = (String) o.get("high");
						String id = (String) o.get("id");
						String country = (String) o.get("country");
						double lon = (Double) o.get("lon");
						double lat = (Double) o.get("lat");
						double altitude = (Double) o.get("altitude");
						Flight f1 = new Flight(id, country, lon, lat, altitude);
						if(high.equals("true"))
								flights.add(f1);
				}catch (JSONException err){
     				err.printStackTrace();
				}
      }
      r.close();
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }

		model.addAttribute("name", flights);
		return "highflights";
	}

	@GetMapping("/map")
	public String history(@RequestParam(name="name", required=false, defaultValue="idk") String name, Model model) {

		ArrayList<Coordinates> coordinates = new ArrayList<Coordinates>();
		// Coordinates c1 = new Coordinates(52.3, 4.4);
		// Coordinates c2 = new Coordinates(52.3, 3.4);
		// coordinates.add(c1);
		// coordinates.add(c2);
    try {
      File f = new File("myJson.json");
      Scanner r = new Scanner(f);
      while (r.hasNextLine()) {
        String data = r.nextLine();
				try {
						JSONObject o = new JSONObject(data);
						double lon = (Double) o.get("lon");
						double lat = (Double) o.get("lat");
						Coordinates c = new Coordinates(lon, lat);
						System.out.println(lat + " " + lon);
						coordinates.add(c);
				}catch (JSONException err){
     				err.printStackTrace();
				}
      }
      r.close();
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }

		model.addAttribute("coords", coordinates);
		return "map";
	}

}

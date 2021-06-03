package com.example.kafka.kafka_demo;

import org.json.*;
import java.io.*;
import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.kafka.kafka_demo.services.*;

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
		return "/flights";
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
		return "/lowflights";
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
		return "/highflights";
	}

	@GetMapping("/map")
	public String history(@RequestParam(name="name", required=false, defaultValue="idk") String name, Model model) {

		// ArrayList<Coordinates> coordinatesAL = new ArrayList<String>();
		//
    // try {
    //   File f = new File("myJson.json");
    //   Scanner r = new Scanner(f);
    //   while (r.hasNextLine()) {
    //     String data = r.nextLine();
    //     coordinatesAL.add(data);
    //   }
    //   r.close();
    // } catch (FileNotFoundException ex) {
    //   ex.printStackTrace();
    // }

		// Coordinates coordList = new Coordinates(53.63118695771819, -4.658511415452493);
		double coordList = 53.63118695771819;
		model.addAttribute("coords", coordList);
		return "map";
	}

}

package com.example.servingwebcontent;

import java.io.*;
import java.net.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import javax.net.ssl.HttpsURLConnection;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadJSON {

  public static String[] getFlights() {
    String jsontext = '[' + getJSON("https://opensky-network.org/api/states/all?lamin=50.3389&lomin=-10.4962&lamax=58.5229&lomax=1.0026") + ']';
		ArrayList<String> flightInfo = new ArrayList<String>();

		try {
        File file = new File("myJSON.json");
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();
		    JSONArray obj = new JSONArray(jsontext); // parse the array
		    for(int i = 0; i < obj.length(); i++){ // iterate over the array
		        JSONObject o = obj.getJSONObject(i);
		        JSONArray flights = o.getJSONArray("states");
		        for(int j=0; j<flights.length();j++) {
		        	Object os = flights.get(j);
		        	String infoVoo = os.toString();

		        	infoVoo = infoVoo.substring(0, infoVoo.length() - 1);
		        	infoVoo = infoVoo.substring(1,infoVoo.length());
              writeInJson(infoVoo);
		        	flightInfo.add(infoVoo);
		        }
		    }
		} catch (JSONException e){
		    e.printStackTrace();
		} catch (IOException e) {
      e.printStackTrace();
    }

    String [] voos = new String[flightInfo.size()];

    Iterator l = flightInfo.iterator();
    int k=0;
    while(l.hasNext()){
      voos[k] = l.next().toString();
      k++;
    }
    return voos;
  }

  public static void writeInJson(String info) {
    try {
      String line;
      File file = new File("myJSON.json");
      BufferedReader br = new BufferedReader(new FileReader(file));
    } catch(IOException e) {
      e.printStackTrace();
    }

    String[] array = info.split(",");
    String icao24 = array[0].toString().trim().replace("\"", "");
    String callsign = array[1].toString().trim().replace("\"", "");
    String origin_country = array[2].toString().trim().replace("\"", "");
    String time_position = array[3].toString().trim();
    String last_contact = array[4].toString().trim();
    String longitude = array[5].toString().trim();
    String latitude = array[6].toString().trim();
    String baro_altitude = array[7].toString().trim();
    String on_ground = array[8].toString().trim();
    String velocity = array[9].toString().trim();
    String true_track = array[10].toString().trim();
    String vertical_rate = array[11].toString().trim();
    String sensors = array[12].toString().trim();
    String geo_altitude = array[13].toString().trim();
    String squawk = array[14].toString().trim().replace("\"", "");
    String spi = array[15].toString().trim();
    String position_source = array[16].toString().trim();

    JSONObject obj = new JSONObject();
    obj.put("icao24", icao24);
    obj.put("callsign", callsign);
    obj.put("origin_country", origin_country);
    obj.put("time_position", time_position);
    obj.put("last_contact", last_contact);
    obj.put("longitude", longitude);
    obj.put("latitude", latitude);
    obj.put("baro_altitude", baro_altitude);
    obj.put("on_ground", on_ground);
    obj.put("velocity", velocity);
    obj.put("true_track", true_track);
    obj.put("vertical_rate", vertical_rate);
    obj.put("sensors", sensors);
    obj.put("geo_altitude", geo_altitude);
    obj.put("squawk", squawk);
    obj.put("spi", spi);
    obj.put("position_source", position_source);

    try(FileWriter fw = new FileWriter("myJSON.json", true)) {

      fw.write(obj.toString() + "\n");
      fw.flush();
    }
    catch(IOException e) {
      e.printStackTrace();
    }
    //System.out.println(obj);
  }


  public static String getJSON(String url) {
        HttpsURLConnection con = null;
        try {
            URL u = new URL(url);
            con = (HttpsURLConnection) u.openConnection();

            con.connect();


            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            return sb.toString();


        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }

}

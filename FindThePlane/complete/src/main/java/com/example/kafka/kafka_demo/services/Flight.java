package com.example.kafka.kafka_demo.services;

public class Flight {

    String id;
    String country;
    double lat;
    double lon;
    double altitude;

    public Flight (String id, String country, double lon, double lat, double altitude){
        this.id = id.replaceAll(" ","");
        this.country = country.replaceAll(" ","");
        this.lon = lon;
        this.lat = lat;
        this.altitude = altitude;
    }

    public void setId(String id){
        this.id=id;
    }

    public void setCountry(String country){
        this.country=country;
    }

    public void setLat(double lat){
        this.lat=lat;
    }

    public void setLon(double lon){
        this.lon=lon;
    }

    public void setAltitude(double altitude){
        this.altitude=altitude;
    }

    public String getId(){
        return id;
    }

    public String getCountry(){
        return country;
    }

    public double getLat(){
        return lat;
    }

    public double getLon(){
        return lon;
    }

    public double getAltitude(){
        return altitude;
    }

    @Override
    public String toString(){
        return "Id: " + id + ", Origin Country: " + country + ", Lon: " + lon + ", Lat: " + lat + ", Altitude: " + altitude + ";\n";
    }

    public String toJsonLow(){
        return "{ \"high\" : \"false\", " + "\"id\" : \"" + id + "\", \"country\" : \"" + country + "\", \"lon\" : " + lon + ", \"lat\" : " + lat + ", \"altitude\" : " + altitude + "}";
    }

    public String toJsonHigh(){
        return "{ \"high\" : \"true\", " +  "\"id\" : \"" + id + "\", \"country\" : \"" + country + "\", \"lon\" : " + lon + ", \"lat\" : " + lat + ", \"altitude\" : " + altitude + "}";
    }

    public Coordinates getCoords() {
      return new Coordinates(this.lon, this.lat);
    }
}

package com.example.servingwebcontent;

public class Flight {
    double lat;
    double lon;

    public Flight (double lat, double lon){
        this.lat=lat;
        this.lon=lon;
    }

    public void setLat(double lat){
        this.lat=lat;
    }

    public void setLon(double lon){
        this.lon=lon;
    }

    public double getLat(){
        return lat;
    }

    public double getLon(){
        return lon;
    }

    @Override
    public String toString(){
        return "Lat: " + lat + ", Lon: " + lon + ";\n";
    }
}
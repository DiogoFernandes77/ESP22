package com.example.kafka.kafka_demo.services;

import java.io.Serializable;

public class Coordinates implements Serializable {

    public double lat;
    public double lon;

    public Coordinates (double lon, double lat){
        this.lon = lon;
        this.lat = lat;
    }


    // public double [] getCoords() {
    //   return [this.lon, this.lat];
    // }
}

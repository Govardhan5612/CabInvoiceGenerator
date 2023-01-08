package org.bridgelabz;

public class Ride {

    double distance;
    double time;
    String rideType;

    public Ride(double distance, double time) {
        this.distance = distance;
        this.time = time;
    }

    public Ride(double distance, double time, String rideType) {
        this.distance = distance;
        this.time = time;
        this.rideType = rideType;
    }
}

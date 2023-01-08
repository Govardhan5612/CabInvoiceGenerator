package org.bridgelabz;

public class CabInvoice {
    enum FareRides {
        FARE_PER_KM(10), FARE_PER_MINUTE(1), MINIMUM_FARE(5), FARE_FOR_PREMIUM_RIDES(15), PREMIUM_FARE_PER_MINUTE(2), PREMIUM_MINIMUM_FARE(20);
        int value;

        FareRides(int value) {
            this.value = value;
        }
    }

    ;

    public double getTotalFare(double distance, double time) {
        double totalFare = FareRides.FARE_PER_KM.value * distance + FareRides.FARE_PER_MINUTE.value * time;
        if (totalFare < FareRides.MINIMUM_FARE.value) {

            return FareRides.MINIMUM_FARE.value;
        } else
            return totalFare;
    }

    public double getTotalFareForPremiumRides(double distance, double time) {
        double totalFare = FareRides.FARE_FOR_PREMIUM_RIDES.value * distance + FareRides.PREMIUM_FARE_PER_MINUTE.value * time;
        if (totalFare < FareRides.PREMIUM_MINIMUM_FARE.value) {
            return FareRides.PREMIUM_MINIMUM_FARE.value;
        } else
            return totalFare;
    }

    public double getTotalFare(Ride[] rides) {
        double aggregateFare = 0;
        for (Ride ride : rides) {
            double totalFare = getTotalFare(ride.distance, ride.time);
            aggregateFare += totalFare;
        }
        return aggregateFare;
    }

    public double getTotalFareForPremiumRides(Ride[] rides) {
        double aggregateFare = 0;
        for (Ride ride : rides) {
            double totalFare = getTotalFareForPremiumRides(ride.distance, ride.time);
            aggregateFare += totalFare;
        }
        return aggregateFare;
    }

    public Invoice getInvoiceOfRides(Ride[] rides) {
        int numberOfRides = rides.length;
        double totalFare = getTotalFare(rides);
        double averageRideFare = totalFare / numberOfRides;
        return new Invoice(numberOfRides, totalFare, averageRideFare);
    }

    public Invoice getInvoiceOfPremiumRides(Ride[] rides) {
        int numberOfRides = rides.length;
        double totalFare = getTotalFareForPremiumRides(rides);
        double averageRideFare = totalFare / numberOfRides;
        return new Invoice(numberOfRides, totalFare, averageRideFare);
    }

    public Invoice getInvoiceOfRidesOfBothRides(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            if (ride.rideType.equals("Normal")) {
                totalFare += getTotalFare(ride.distance, ride.time);
            } else if (ride.rideType.equals("Premium")) {
                totalFare += getTotalFareForPremiumRides(ride.distance, ride.time);
            }
        }
        return new Invoice(rides.length, totalFare, totalFare / rides.length);
    }
}

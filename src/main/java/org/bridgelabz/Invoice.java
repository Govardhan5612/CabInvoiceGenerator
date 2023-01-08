package org.bridgelabz;

import java.util.Objects;

public class Invoice {
    int totalNumberOfRides;
    double totalFare;
    double averageFarePerRide;

    public Invoice() {
    }

    public Invoice(int totalNumberOfRides, double totalFare, double averageFarePerRide) {
        this.totalNumberOfRides = totalNumberOfRides;
        this.totalFare = totalFare;
        this.averageFarePerRide = averageFarePerRide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return totalNumberOfRides == invoice.totalNumberOfRides && Double.compare(invoice.totalFare, totalFare) == 0 && Double.compare(invoice.averageFarePerRide, averageFarePerRide) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalNumberOfRides, totalFare, averageFarePerRide);
    }
}

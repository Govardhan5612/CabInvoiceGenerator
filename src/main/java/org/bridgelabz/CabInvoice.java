package org.bridgelabz;

public class CabInvoice {
    static final int FARE_PER_KM = 10;
    static final int FARE_PER_MINUTE = 1;
    public double getTotalFare(double distance, double time)
    {
        double totalFare = FARE_PER_KM*distance+FARE_PER_MINUTE*time;
        if(totalFare<5)
        {
            totalFare = 5;
            return totalFare;
        }
        else
            return totalFare;
    }
}

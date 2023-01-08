package com.bridgelabz;

import org.bridgelabz.CabInvoice;
import org.bridgelabz.Invoice;
import org.bridgelabz.Ride;
import org.bridgelabz.RideRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceTest {
        @Test
        public void givenTimeAndDistanceShould_ReturnTotalFare(){
        CabInvoice cabinvoice = new CabInvoice();
        double totalFare = cabinvoice.getTotalFare(10,1);
        Assertions.assertEquals(101,totalFare);
    }
        @Test
        public void givenTimeAndDistanceShould_ReturnMinimumFare(){
        CabInvoice cabinvoice = new CabInvoice();
        double totalFare = cabinvoice.getTotalFare(0.2,1);
        Assertions.assertEquals(5,totalFare);
    }
    @Test
    public void givenMultipleRidesShould_ReturnAggregateFare(){
        CabInvoice cabinvoice = new CabInvoice();
        Ride[] rides ={new Ride(12.0,3.0),new Ride(14.0,5.0),new Ride(0.1,3.0)};
        double totalFare = cabinvoice.getTotalFare(rides);
        Assertions.assertEquals(273,totalFare);
    }
    @Test
    public void givenMultipleRidesShould_ReturnInvoice() {
        CabInvoice cabinvoice = new CabInvoice();
        Invoice invoice = new Invoice();
        Ride[] rides ={new Ride(12.0,3.0),new Ride(14.0,5.0),new Ride(0.1,3.0)};
        Invoice actualInvoice = cabinvoice.getInvoiceOfRides(rides);
        Invoice expectedInvoice = new Invoice(3,273,91);
        Assertions.assertEquals(expectedInvoice,actualInvoice);
    }
    @Test
    public void givenUserId_OfMultipleRidesShould_ReturnInvoice(){
        CabInvoice cabinvoice = new CabInvoice();
        Ride[] rides1 = {new Ride(12.0,3.0),new Ride(14.0,5.0),new Ride(0.1,3.0)};
        Ride[] rides2 = {new Ride(12.5,4.8),new Ride(34.4,9.7)};
        RideRepository repository = new RideRepository();
        repository.addRides("user101",rides1);
        repository.addRides("user102",rides2);
        Invoice actualInvoice1 = repository.getInvoiceFromUserId("user102");
        Invoice actualInvoice2 = repository.getInvoiceFromUserId("user101");
        Invoice expectedInvoice1 = new Invoice(2,483.5,241.75);
        Invoice expectedInvoice2 = new Invoice(3,273,91);
        Assertions.assertEquals(expectedInvoice1,actualInvoice1);
        Assertions.assertEquals(expectedInvoice2,actualInvoice2);
    }
}

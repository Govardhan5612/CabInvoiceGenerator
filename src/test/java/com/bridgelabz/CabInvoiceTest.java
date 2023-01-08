package com.bridgelabz;

import org.bridgelabz.CabInvoice;
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
}

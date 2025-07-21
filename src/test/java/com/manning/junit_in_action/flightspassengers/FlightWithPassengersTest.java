package com.manning.junit_in_action.flightspassengers;

import com.manning.junit_in_action.flights.Flight;
import com.manning.junit_in_action.passengers.Passenger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlightWithPassengersTest {

    private Flight flight = new Flight("AA123", 1);

    @Test
    public void testAddRemovePassenger() {
        Passenger passenger = new Passenger("124-56-7890", "Michael Johnson", "US");

        assertTrue(flight.addPassenger(passenger));
        assertEquals(1, flight.getNumberOfPassengers());
        assertEquals(flight, passenger.getFlight());

        assertTrue(flight.removePassenger(passenger));
        assertEquals(0, flight.getNumberOfPassengers());
        assertEquals(null, passenger.getFlight());
    }

    @Test
    public void testNumberOfSeats() {
        Passenger passenger1 = new Passenger("124-56-7890", "Michael Johnson", "US");

        flight.addPassenger(passenger1);
        assertEquals(1, flight.getNumberOfPassengers());

        Passenger passenger2 = new Passenger("127-23-7991", "John Smith", "GB");

        assertThrows(RuntimeException.class,
                () -> flight.addPassenger(passenger2));
    }
}

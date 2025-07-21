package com.manning.junit_in_action.passengers;

import com.manning.junit_in_action.flights.Flight;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Passenger {

    private String identifier;
    private String name;
    private String countryCode;
    private Flight flight;

    public Passenger(String identifier, String name, String countryCode) {
        if (!List.of(Locale.getISOCountries()).contains(countryCode)) {
            throw new RuntimeException("국가 코드가 적절하지 않습니다");
        }
        this.identifier = identifier;
        this.name = name;
        this.countryCode = countryCode;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Passenger " + name + " with identifier: " + identifier + " from " + countryCode;
    }
}

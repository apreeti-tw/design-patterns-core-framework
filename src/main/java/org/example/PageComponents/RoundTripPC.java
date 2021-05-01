package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.example.AbstractComponents.SearchFlightsInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class RoundTripPC extends AbstractComponent implements SearchFlightsInterface {
    public RoundTripPC(WebDriver driver, By flightSearchSectionElement) {
        super(driver, flightSearchSectionElement);
    }

    @Override
    public void checkFlightAvailability(HashMap<String, String> bookingDetails) {
    }
}

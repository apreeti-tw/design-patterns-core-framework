package org.example.AbstractComponents;

import org.example.PageComponents.OneWayTripPC;
import org.example.PageComponents.RoundTripPC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StrategyFactory {
    private WebDriver driver;
    private By sectionElement;

    public StrategyFactory(WebDriver driver, By sectionElement) {
        this.driver = driver;
        this.sectionElement = sectionElement;
    }

    public SearchFlightsInterface createFactory(String tripType) {
        if (tripType.equals("ONEWAY"))
            return new OneWayTripPC(driver, sectionElement);
        if (tripType.equals("ROUNDTRIP"))
            return new RoundTripPC(driver, sectionElement);
        return null;
    }
}

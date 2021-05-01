package org.example.PageObjects;

import org.example.AbstractComponents.SearchFlightsInterface;
import org.example.AbstractComponents.StrategyFactory;
import org.example.PageComponents.FooterPC;
import org.example.PageComponents.NavigationPC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomePage {
    private WebDriver driver;
    private SearchFlightsInterface searchFlightsInterface;

    By footerSectionElement = By.id("traveller-home");
    By navigationSectionElement = By.id("buttons");
    By flightSearchSectionElement  = By.id("flightSearchContainer");

    public TravelHomePage(WebDriver driver){
        this.driver = driver;
    }

    public void goTo(String url){
        driver.get(url);
    }

    public NavigationPC getNavigation(){
        return new NavigationPC(driver, navigationSectionElement);
    }

    public FooterPC getFooter(){
        return new FooterPC(driver, footerSectionElement);
    }

    public void checkFlightAvailability(HashMap<String, String> bookingDetails) {
        searchFlightsInterface.checkFlightAvailability(bookingDetails);
    }

    public void setTripStrategy(String tripType) {
        this.searchFlightsInterface =  new StrategyFactory(driver, flightSearchSectionElement).createFactory(tripType);
    }
}

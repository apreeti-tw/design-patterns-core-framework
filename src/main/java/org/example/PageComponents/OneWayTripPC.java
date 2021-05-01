package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.example.AbstractComponents.SearchFlightsInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.function.Consumer;

public class OneWayTripPC extends AbstractComponent implements SearchFlightsInterface {
    private WebDriver driver;
    private By oneTrip = By.cssSelector("input[value='OneWay']");
    private By departure = By.xpath("//input[contains(@id, 'originStation')]");
    private By search = By.name("ctl00$mainContent$btn_FindFlights");
    private By seniorCitizen = By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']");

    public OneWayTripPC(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
        this.driver = driver;
    }

    @Override
    public void checkFlightAvailability(HashMap<String, String> bookingDetails) {
        setState(state -> selectOriginCity(bookingDetails.get("origin")));
        selectDestinationCity(bookingDetails.get("destination"));
        findElement(seniorCitizen).click();
        findElement(search).click();
    }

    public void selectOriginCity(String city){
        findElement(departure).click();
        findElement(By.xpath("//a[@value='"+city+"']")).click();
    }

    public void selectDestinationCity(String city) {
        new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@value='"+city+"'])[2]")));
        findElement(By.xpath("(//a[@value='"+city+"'])[2]")).click();
    }

    public void setState(Consumer<OneWayTripPC> consumer){
        findElement(oneTrip).click();
        consumer.accept(this);
    }
}

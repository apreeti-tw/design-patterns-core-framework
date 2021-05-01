package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPC extends AbstractComponent {
    private WebDriver driver;
    By flights = By.cssSelector("a[title='Flights']");

    public NavigationPC(WebDriver driver, By navigationSectionElement) {
        super(driver, navigationSectionElement);
        this.driver = driver;
    }

    public String getFlightAttr(){
        return findElement(flights).getAttribute("class");
    }
}

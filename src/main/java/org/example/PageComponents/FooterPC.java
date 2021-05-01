package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterPC extends AbstractComponent {
    private WebDriver driver;
    By flights = By.cssSelector("a[title='Flights']");

    public FooterPC(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
        this.driver = driver;
    }

    public String getFlightAttr(){
        return findElement(flights).getAttribute("class");
    }
}

package org.example.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractComponent {
    private WebDriver driver;
    private WebElement sectionElement;

    public AbstractComponent(WebDriver driver, By sectionElement) {
        this.driver = driver;
        this.sectionElement = driver.findElement(sectionElement);
    }

    public WebElement findElement(By element){
        return sectionElement.findElement(element);
    }
}

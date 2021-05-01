package org.example.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver initialiseDriver() throws IOException {
        WebDriver driver;
        Properties prop = new Properties();
        prop.load(new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/application-test.properties"));

        switch (prop.getProperty("browser")){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/chromedriver");
                driver = new ChromeDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + prop.getProperty("browser"));
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}

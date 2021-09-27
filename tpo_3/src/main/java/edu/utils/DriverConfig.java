package edu.utils;

import edu.exceptions.InvalidDriverException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static edu.utils.PropertyNames.*;

public class DriverConfig {
    static {
        try {
            String chrome = ConfProperties.getProperty(CHROME_DRIVER);
            String firefox = ConfProperties.getProperty(FIREFOX_DRIVER);
            String currentDriver = ConfProperties.getProperty(CURRENT_DRIVER);
            switch (currentDriver) {
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", firefox);
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", chrome);
                default:
                    System.setProperty("webdriver.chrome.driver", chrome);
            }
        } catch (InvalidDriverException e) {
            System.err.println(e.getMessage());
        }
    }

    public static WebDriver getCurrentDriver() {
        try {
            String currentDriver = ConfProperties.getProperty(CURRENT_DRIVER);
            switch (currentDriver) {
                case "firefox":
                    return new FirefoxDriver();
                case "chrome":
                default:
                    return new ChromeDriver();
            }
        } catch (IllegalStateException e) {
            throw new InvalidDriverException();
        }
    }
}

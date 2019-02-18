package com.safebear.auto.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Utils {
    private static final String URL = System.getProperty("url", "http://localhost:8080");
    private static final String BROWSER = System.getProperty("browser", "chrome");

    public static String getUrl() {
        return URL;
    }

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1366,768");

        switch (BROWSER) {
            case "chrome":
                return new ChromeDriver(options);

            default:
                return new ChromeDriver(options);
        }
    }
}

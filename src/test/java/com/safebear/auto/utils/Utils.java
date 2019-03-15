package com.safebear.auto.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class Utils {

    // Get our URL and Browsername from the CI or use the default
    protected static final String URL = System.getProperty("url", "http://localhost:8888");
    private static final String BROWSERNAME = System.getProperty("browser", "chrome");

    // This will be used to store an instance of our driver (e.g. ChromeDriver, GeckoDriver etc)
    protected static WebDriver browser;

    protected static void initializeBrowser() {

        System.setProperty("webdriver.chrome.drivers", "src/test/resources/drivers/chromedriver.exe");
        System.setProperty("webdriver.firefox.drivers", "src/test/resources/drivers/geckodriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1366,768");

        switch (BROWSERNAME) {

            case "chrome":
                browser = new ChromeDriver(options);
                break;

            case "headless":
                options.addArguments("headless");
                browser = new ChromeDriver(options);
                break;

            case "firefox":

                browser = new FirefoxDriver();

            case "ie":

                // Change all this to use the Selenium server and switch using Capabilities.

            default:
                browser = new ChromeDriver(options);
        }
    }

    protected static WebElement waitForElement(By locator){

        WebElement element = null;

        try {

            element = (new WebDriverWait(browser, 5))
                    .until(ExpectedConditions.presenceOfElementLocated(locator));

        }catch (TimeoutException e){

            e.printStackTrace();
            Assert.fail("The element couldn't be found!");
        }

        return element;

    }

    protected static WebElement waitForElementToBeEnabled(By locator){

        WebElement element = null;

        try {

            element = (new WebDriverWait(browser, 5))
                    .until(ExpectedConditions.elementToBeClickable(locator));

        }catch (TimeoutException e){

            e.printStackTrace();
            Assert.fail("The element couldn't be found!");
        }

        return element;


    }




}

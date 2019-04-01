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

import java.util.ArrayList;
import java.util.List;

public abstract class Utils {

    // Get our URL and Browsername from the CI or use the default
    protected static final String URL = System.getProperty("url", "http://localhost:8080");
    private static final String BROWSERNAME = System.getProperty("browser", "chrome");
    private static final String WAIT = System.getProperty( "waitTime", "10");


    // This will be used to store an instance of our driver (e.g. ChromeDriver, GeckoDriver etc)
    protected static WebDriver browser;

    protected static void initializeBrowser() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver-74");
        System.setProperty("webdriver.firefox.driver", "src/test/resources/drivers/geckodriver");

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

            element = (new WebDriverWait(browser, Integer.parseInt(WAIT)))
                    .until(ExpectedConditions.presenceOfElementLocated(locator));

        }catch (TimeoutException e){

            e.printStackTrace();
            Assert.fail("Timeout: The element couldn't be found in " + WAIT + " seconds!");

        }catch (Exception e){

            e.printStackTrace();
            Assert.fail("Something went wrong!");

        }

        return element;

    }

    protected static WebElement waitForElementToBeEnabled(By locator){

        WebElement element = null;

        try {

            element = (new WebDriverWait(browser, Integer.parseInt(WAIT)))
                    .until(ExpectedConditions.elementToBeClickable(locator));

        }catch (TimeoutException e){

            e.printStackTrace();
            Assert.fail("The element couldn't be found!");
        }

        return element;


    }

    protected static List<WebElement> waitForElements (By locator) {
        //create a counter and assign it a 0 value
        int i = 0;
        //create a list of type webelement and call it elements and give it a value of null or empty
        List<WebElement> elements = new ArrayList<>();

        //loop -> while the list created above is empty and is smaller than 6 do the following below:
        while (elements.isEmpty() && i < (Integer.parseInt(WAIT) * 1000) ){
            //to the list called 'elements' call the webdriver.findelement with the locator holder
            elements = browser.findElements(locator);
            //increment counter by 1
            i++;
            //if the list is empty
            if (elements.isEmpty()){
            //sleep for 1 second
                try {
                    Thread.sleep(1);
                    //catch an error not quite sure what the catch is looking for here
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            //otherwise return the list
            } else {

                return elements;
            }

        }

        Assert.fail("Timeout: Couldn't find the Elements on the page");

        return elements;

    }

    protected static List<WebElement> waitForElementsNoFail (By locator) {
        //create a counter and assign it a 0 value
        int i = 0;
        //create a list of type webelement and call it elements and give it a value of null or empty
        List<WebElement> elements = new ArrayList<>();

        //loop -> while the list created above is empty and is smaller than 6 do the following below:
        while (elements.isEmpty() && i < 6 ){
            //to the list called 'elements' call the webdriver.findelement with the locator holder
            elements = browser.findElements(locator);
            //increment counter by 1
            i++;
            //if the list is empty
            if (elements.isEmpty()){
                //sleep for 1 second
                try {
                    Thread.sleep(3000);
                    //catch an error not quite sure what the catch is looking for here
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //otherwise return the list
            } else {

                return elements;
            }

        }

        return elements;

    }


}

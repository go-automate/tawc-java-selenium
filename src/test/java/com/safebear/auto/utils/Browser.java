package com.safebear.auto.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Browser extends PropertiesFactory {

    // Set up our empty driver.
    protected static RemoteWebDriver browser;

    /**
     * Getter for the URL
     * @return URL for the website under test.
     */
    protected static String getURL() {
        return URL;
    }

    /**
     * Initialise our browser
     * @throws MalformedURLException
     */
    protected static void initializeBrowser() throws MalformedURLException {

        // Load our Properties file
        loadPropertiesFile();

        // Check System Properties (i.e. has anything changed in Maven)
        checkSystemProperties();

        DesiredCapabilities cap = new DesiredCapabilities();
        Platform platform = Platform.fromString(OS.toUpperCase());

        ChromeOptions chromeOptions;
        FirefoxProfile firefoxProfile;
        FirefoxOptions firefoxOptions;


        switch(BROWSERNAME.toUpperCase()) {

            case ("FIREFOX"):

                System.out.println(" Executing on FIREFOX");

                WebDriverManager.firefoxdriver().setup();

                browser = new FirefoxDriver();

                // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
                browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                break;


            case ("CHROME"):

                System.out.println(" Executing on CHROME");

                WebDriverManager.chromedriver().setup();

                browser = new ChromeDriver();

                // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
                browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                break;


            case ("CHROME_HEADLESS"):

                System.out.println(" Executing on CHROME HEADLESS");

                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("headless");
                chromeOptions.addArguments("window-size=1920,1080");
                chromeOptions.addArguments("start-maximized");


                WebDriverManager.chromedriver().setup();

                browser = new ChromeDriver(chromeOptions);

                // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
                browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                break;


            default:

                throw new IllegalArgumentException("The Browser Type is Undefined");

        }

    }

}

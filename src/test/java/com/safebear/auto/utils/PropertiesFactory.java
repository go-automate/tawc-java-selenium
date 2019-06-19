package com.safebear.auto.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFactory {

    /****************************
     /* Variables for default values
     ****************************/

    // Selenium Hub
    protected static String defaultHubUrl;

    // Test Environment
    protected static String defaultUrl;
    protected static String defaultBrowsername;
    protected static String defaultOs;

    /****************************
    /* Variables for static values
     ****************************/

    // Selenium Hub
    protected static String hubUrl;

    // Test Environment
    protected static String URL;
    protected static String BROWSERNAME;
    protected static String OS;


    // Get our values from the config.properties file in the resources folder
    public static void loadPropertiesFile(){

        try {

            InputStream input = Browser.class.getClassLoader().getResourceAsStream("config.properties");

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Unable to find config.properties");
                return;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            // Build our Selenium Hub URLs
            defaultHubUrl = prop.getProperty("default.hub.url") + ":" + prop.getProperty("default.hub.port") + "/wd/hub";

            // Get our Test Environment Variables
            defaultUrl = prop.getProperty("default.env.url");
            defaultBrowsername = prop.getProperty("default.browser");
            defaultOs = prop.getProperty("default.os");



        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void checkSystemProperties(){

        URL = System.getProperty("url", defaultUrl);
        BROWSERNAME = System.getProperty("browser", defaultBrowsername);
        OS = System.getProperty("os", defaultOs);

        hubUrl = System.getProperty("huburl", defaultHubUrl);

    }

}

package com.safebear.auto.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFactory {

    /****************************
     /* Variables for default values
     ****************************/

    // Test Environment
    protected static String defaultUrl;
    protected static String defaultBrowsername;
    protected static String defaultDataset;

    /****************************
    /* Variables for static values
     ****************************/

    // Test Environment
    protected static String URL;
    protected static String BROWSERNAME;
    protected static String DATASET;


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


            // Get our Test Environment Variables
            defaultUrl = prop.getProperty("default.env.url");
            defaultBrowsername = prop.getProperty("default.browser");
            defaultDataset = prop.getProperty("default.dataset");



        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void checkSystemProperties(){

        URL = System.getProperty("url", defaultUrl);
        BROWSERNAME = System.getProperty("browser", defaultBrowsername);
        DATASET = System.getProperty("dataset", defaultDataset);


    }

}

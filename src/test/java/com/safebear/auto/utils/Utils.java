package com.safebear.auto.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Utils {
    private static final String URL = System.getProperty("url", "http://localhost:8080");
    private static final String BROWSER = System.getProperty("browser", "chrome");

    public static List<List<String>> getCsvData(String filename){
        File file = new File(filename);
        List<List<String>> rows = new ArrayList<>();
        Scanner inputStream;

        try {
            inputStream = new Scanner(file);

            while (inputStream.hasNext()) {
                String row = inputStream.next();
                String[] data = row.split(",");
                rows.add(Arrays.asList(data));
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return rows;
            }



    public static String getUrl() {
        return URL;
    }

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1366,768");

        switch (BROWSER) {
            case "chrome":
                return new ChromeDriver(options);

    case "headless":
    options.addArguments("headless", "disable-gpu");
    return new ChromeDriver(options);
            default:
                return new ChromeDriver(options);
        }
    }
}

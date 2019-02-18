package com.safebear.auto.tests;

import com.safebear.auto.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    WebDriver driver;

    @BeforeTest
    public void  setUp(){
        driver = Utils.getDriver();
    }

    @AfterTest
    public void tearDown(){

        try {
            Thread.sleep(Integer.parseInt(System.getProperty("sleep","2000")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();

    }

}

package com.safebear.auto.tests;

import com.safebear.auto.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    WebDriver driver;

    @BeforeTest
    public void  setUp(){
        driver = Utils.getDriver();
    }

}

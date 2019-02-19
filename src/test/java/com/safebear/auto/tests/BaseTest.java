package com.safebear.auto.tests;

import com.safebear.auto.pages.LoginPage;
import com.safebear.auto.pages.ToolsPage;
import com.safebear.auto.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest{

    WebDriver driver;

    protected LoginPage loginPage;
    protected ToolsPage toolsPage;


    @BeforeTest
    public void  setUp(){
        driver = Utils.getDriver();

        loginPage = new LoginPage(driver);
        toolsPage = new ToolsPage(driver);
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

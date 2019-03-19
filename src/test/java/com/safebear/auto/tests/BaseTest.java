package com.safebear.auto.tests;

import com.safebear.auto.pages.HomePage;
import com.safebear.auto.pages.ViewProductPage;
import com.safebear.auto.utils.Utils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest extends Utils {


    HomePage homePage;
    ViewProductPage viewProductPage;


    @BeforeTest
    public void  setUp(){
        initializeBrowser();
        homePage = new HomePage();
        viewProductPage = new ViewProductPage();
    }

    @BeforeMethod
    public void setUpTest(){
        browser.get(URL);
    }

    @AfterTest
    public void tearDown(){

       browser.quit();

    }

}

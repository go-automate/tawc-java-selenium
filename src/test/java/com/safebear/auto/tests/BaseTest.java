package com.safebear.auto.tests;

import com.safebear.auto.pages.*;
import com.safebear.auto.utils.Utils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest extends Utils {


    HomePage homePage;
    ViewProductPage viewProductPage;
    BasePage basePage;
    AddProductPage addProductPage;
    EditProductPage editProductPage;


    @BeforeTest
    public void  setUp(){
        initializeBrowser();
        homePage = new HomePage();
        viewProductPage = new ViewProductPage();
        basePage = new BasePage();
        addProductPage = new AddProductPage();
        editProductPage = new EditProductPage();
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

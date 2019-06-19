package com.safebear.auto.tests;

import com.safebear.auto.pages.*;
import com.safebear.auto.utils.Browser;
import com.safebear.auto.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

public abstract class BaseTest extends Browser {


    protected HomePage homePage;
    protected ViewProductPage viewProductPage;
    protected BasePage basePage;
    protected AddProductPage addProductPage;
    protected EditProductPage editProductPage;


    protected void createProduct(TestData product) {


        homePage.clickOnAddProductButton();

        addProductPage.enterProductName(product.getName());
        addProductPage.enterProductDescription(product.getDescription());
        addProductPage.enterProductPrice(product.getPrice());

        addProductPage.clickOnSubmitButton();

        viewProductPage.clickOnHomeButton();

    }

    protected void cSetUpEnvironment(TestData product) {

        // CPSU01
        // SETUP: Check whether the `Product` is present in the list, if it's there, delete it.
        while(homePage.isProductInList(product.getName())){
            deleteProduct(product.getName());
        }

        // ASSERT: Product is not in list
        Assert.assertFalse(homePage.isProductInList(product.getName()));

    }

    protected void rudSetUpEnviroment(TestData product){


        /**********************************************************************
         This checks to see if a product from our test dataset has been created. If it has, it deletes it
         We have two types of products in the list, one that is created at the start of the test and one that has its name edited.
         So we check for both.
         **************************************************************************/
        while(homePage.isProductInList(product.getName()) || homePage.isProductInList(product.getEditName())){
            if(homePage.isProductInList(product.getName())){
                deleteProduct(product.getName());
            }else {
                deleteProduct(product.getEditName());
            }
        }
        createProduct(product);


    }

    protected void deleteProduct(String name){

        homePage.clickOnProductName(name);
        viewProductPage.clickOnDeleteButton();


    }

    protected void clearUpEnvironment(TestData product) {

        // CPTD01
        // TEARDOWN: Delete the `Product` that was created.
        //deleteProduct(product.getName());
        // ASSERT: `Product` is no longer listed.
        //Assert.assertFalse(homePage.isProductInList(product.getName()));
        while(homePage.isProductInList(product.getName()) || homePage.isProductInList(product.getEditName())){
            if(homePage.isProductInList(product.getName())){
                deleteProduct(product.getName());
                Assert.assertFalse(homePage.isProductInList(product.getName()));
            }else {
                deleteProduct(product.getEditName());
                Assert.assertFalse(homePage.isProductInList(product.getEditName()));
            }
        }

    }


    @BeforeTest
    public void  setUp() throws MalformedURLException {
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

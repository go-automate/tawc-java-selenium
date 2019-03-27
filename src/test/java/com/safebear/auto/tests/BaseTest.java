package com.safebear.auto.tests;

import com.safebear.auto.pages.*;
import com.safebear.auto.utils.TestData;
import com.safebear.auto.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest extends Utils {


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
            deleteProduct(product);
        }

        // ASSERT: Product is not in list
        Assert.assertFalse(homePage.isProductInList(product.getName()));

    }

    protected void rudSetUpEnviroment(TestData product){

        String name = "";
        String editName = "";


        while(homePage.isProductInList(product.getName()) || homePage.isProductInList(product.getEditName())){
            if(homePage.isProductInList(product.getName())){
                name = product.getName();
            }if(homePage.isProductInList(product.getEditName())){
                editName = product.getEditName();
            }else{

            }



            deleteProduct(name, editName);
        }
        createProduct(product);


    }

    protected void deleteProduct(String name, String editName){

        homePage.clickOnProductName(name);
        viewProductPage.clickOnDeleteButton();
        homePage.clickOnProductName(editName);
        viewProductPage.clickOnDeleteButton();


    }

    protected void clearUpEnvironment(String name,  product) {

        // CPTD01
        // TEARDOWN: Delete the `Product` that was created.
        deleteProduct(name,editName);
        // ASSERT: `Product` is no longer listed.
        Assert.assertFalse(homePage.isProductInList(product.getName()));

    }


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

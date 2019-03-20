package com.safebear.auto.tests;

import com.safebear.auto.pages.locators.ViewProductPageLocators;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductCreateTests extends BaseTest {


    private void deleteProduct(String name){

        homePage.clickOnProductName(name);
        viewProductPage.clickOnDeleteButton();

    }


    @BeforeMethod(dependsOnMethods = "setUpTest")
    public void setUpEnvironment() {


        String name = "chicken";

        // CPSU01
        // SETUP: Check whether the `Product` is present in the list, if it's there, delete it.
        while(homePage.isProductInList(name)){
            deleteProduct(name);
        }

        // ASSERT: Product is not in list
        Assert.assertFalse(homePage.isProductInList(name));

    }

    @AfterMethod
    public void clearUpEnvironment(){

        // CPTD01
        // TEARDOWN: Delete the `Product` that was created.
        deleteProduct("chicken");
        // ASSERT: `Product` is no longer listed.
        Assert.assertFalse(homePage.isProductInList("chicken"));


    }


    @Test
    public void createProductTest(){


        // CP01
        // Navigate to the `Products Page`
        // This happens in the 'BeforeMethod' in BaseTest.


        // ASSERT: We're on the `Products Page` of the Website
        Assert.assertEquals(homePage.getPageUrl(), "products");



        // CP02
        // Click on the `Add Product` button
        homePage.clickOnAddProductButton();

         // ASSERT: We're on the `Add Product` page
        Assert.assertEquals(homePage.getPageUrl(), "product-add");

         // CP03
         // Enter a `Name`, `Description` and `Price` for a Product (see `test-data.adoc` for Test Data)
         // `Product` details entered
        addProductPage.enterProductName("chicken");
        addProductPage.enterProductDescription("bird");
        addProductPage.enterProductPrice("3.50");

         // CP04
         // Press the `Save` button.
        addProductPage.clickOnSubmitButton();


         // ASSERT: The `View` product page opens.
        //homePage.clickOnProductName("chicken");
        Assert.assertEquals(viewProductPage.getPageUrl(), "product-details");

         // ASSERT: The product details are correct (`name`, `description`, `price`).

       // System.out.print(viewProductPage.getProductName());
        Assert.assertEquals(viewProductPage.getProductName(), "chicken");
        Assert.assertEquals(viewProductPage.getProductDescription(), "bird");
        Assert.assertEquals(viewProductPage.getProductPrice(), "3.5");

         // CP05
         // Press the `Products Page` button.
        viewProductPage.clickOnHomeButton();


         // ASSERT: We're returned to the `Products Page`.
        Assert.assertEquals(homePage.getPageUrl(), "products");

         // ASSERT: The new `Product` is listed.
        Assert.assertEquals(homePage.getNameOfLastProductInTheList(), "chicken");



    }




}

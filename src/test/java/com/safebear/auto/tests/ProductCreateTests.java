package com.safebear.auto.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductCreateTests extends BaseTest {


    private void deleteProduct(String name){

        homePage.clickOnProductName(name);
        viewProductPage.clickOnDeleteButton();

    }


    @BeforeMethod(dependsOnMethods = "setUpTest")
    public void setUpEnvironment() {


        String name = "carrot";

        // CPSU01
        // SETUP: Check whether the `Product` is present in the list, if it's there, delete it.
        if(homePage.isProductInList(name)){
            deleteProduct(name);
        }

        // ASSERT: Product is not in list
        Assert.assertFalse(homePage.isProductInList(name));

    }


    @Test
    public void createProductTest(){


         // CP01
         // Navigate to the `Products Page`

         // ASSERT: We're on the `Products Page` of the Website

         // CP02
         // Click on the `Add Product` button

         // ASSERT: We're on the `Add Product` page

         // CP03
         // Enter a `Name`, `Description` and `Price` for a Product (see `test-data.adoc` for Test Data)
         // `Product` details entered

         // CP04
         // Press the `Save` button.


         // ASSERT: The `View` product page opens.

         // ASSERT: The product details are correct (`name`, `description`, `price`).

         // CP05
         // Press the `Products Page` button.


         // ASSERT: We're returned to the `Products Page`.

         // ASSERT: The new `Product` is listed.

         // CPTD01
         // TEARDOWN: Delete the `Product` that was created.
         // ASSERT: `Product` is no longer listed.


    }




}

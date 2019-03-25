package com.safebear.auto.tests;

import com.safebear.auto.pages.locators.ViewProductPageLocators;
import com.safebear.auto.utils.StaticProvider;
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

    public void setUpEnvironment(String name) {

        // CPSU01
        // SETUP: Check whether the `Product` is present in the list, if it's there, delete it.
        while(homePage.isProductInList(name)){
            deleteProduct(name);
        }

        // ASSERT: Product is not in list
        Assert.assertFalse(homePage.isProductInList(name));

    }

    public void clearUpEnvironment(String name){

        // CPTD01
        // TEARDOWN: Delete the `Product` that was created.
        deleteProduct(name);
        // ASSERT: `Product` is no longer listed.
        Assert.assertFalse(homePage.isProductInList(name));


    }


    @Test(dataProvider = "testProducts", dataProviderClass = StaticProvider.class)
    public void createProductTest(String name, String description, String price){


        // CP01
        // Navigate to the `Products Page`
        // This happens in the 'BeforeMethod' in BaseTest.

        setUpEnvironment(name);

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
        addProductPage.enterProductName(name);
        addProductPage.enterProductDescription(description);
        addProductPage.enterProductPrice(price);

         // CP04
         // Press the `Save` button.
        addProductPage.clickOnSubmitButton();


         // ASSERT: The `View` product page opens.
        //homePage.clickOnProductName("chicken");
        Assert.assertEquals(viewProductPage.getPageUrl(), "product-details");

         // ASSERT: The product details are correct (`name`, `description`, `price`).

       // System.out.print(viewProductPage.getProductName());
        Assert.assertEquals(viewProductPage.getProductName(), name);
        Assert.assertEquals(viewProductPage.getProductDescription(), description);
        Assert.assertEquals(viewProductPage.getProductPrice(), price);

         // CP05
         // Press the `Products Page` button.
        viewProductPage.clickOnHomeButton();


         // ASSERT: We're returned to the `Products Page`.
        Assert.assertEquals(homePage.getPageUrl(), "products");

         // ASSERT: The new `Product` is listed.
        Assert.assertEquals(homePage.getNameOfLastProductInTheList(), name);

        clearUpEnvironment(name);

    }

}

package com.safebear.auto.tests;

import com.safebear.auto.pages.locators.ViewProductPageLocators;
import com.safebear.auto.utils.EditStaticProvider;
import com.safebear.auto.utils.StaticProvider;
import com.safebear.auto.utils.TestData;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductCreateTests extends BaseTest {


    @Test(dataProvider = "testEditProducts", dataProviderClass = EditStaticProvider.class)
    public void createProductTest(TestData product){


        // CP01
        // Navigate to the `Products Page`
        // This happens in the 'BeforeMethod' in BaseTest.

        cSetUpEnvironment(product);

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
        addProductPage.enterProductName(product.getName());
        addProductPage.enterProductDescription(product.getDescription());
        addProductPage.enterProductPrice(product.getPrice());

         // CP04
         // Press the `Save` button.
        addProductPage.clickOnSubmitButton();


         // ASSERT: The `View` product page opens.
        //homePage.clickOnProductName("chicken");
        Assert.assertEquals(viewProductPage.getPageUrl(), "product-details");

         // ASSERT: The product details are correct (`name`, `description`, `price`).

       // System.out.print(viewProductPage.getProductName());
        Assert.assertEquals(viewProductPage.getProductName(), product.getName());
        Assert.assertEquals(viewProductPage.getProductDescription(), product.getDescription());
        Assert.assertEquals(viewProductPage.getProductPrice(), product.getPrice());

         // CP05
         // Press the `Products Page` button.
        viewProductPage.clickOnHomeButton();


         // ASSERT: We're returned to the `Products Page`.
        Assert.assertEquals(homePage.getPageUrl(), "products");

         // ASSERT: The new `Product` is listed.
        Assert.assertEquals(homePage.getNameOfLastProductInTheList(), product.getName());

        clearUpEnvironment(product);

    }

}

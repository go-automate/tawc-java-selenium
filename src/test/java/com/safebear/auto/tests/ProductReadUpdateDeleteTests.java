package com.safebear.auto.tests;

import com.safebear.auto.utils.EditStaticProvider;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;

public class ProductReadUpdateDeleteTests extends BaseTest {


    public void deleteProduct(String name){

        homePage.clickOnProductName(name);
        viewProductPage.clickOnDeleteButton();
    }

    private void deleteProductsInTable(){


        while(!homePage.getNamesOfProductsInTheList().isEmpty()){

            homePage.clickOnFirstProductInTable();
            viewProductPage.clickOnDeleteButton();
            //viewProductPage.clickOnHomeButton();
            Assert.assertEquals(homePage.getPageUrl(), "products");
        }

    }


    public void setUpEnviroment(String name, String description, String price){


            deleteProductsInTable();
            createProduct(name, description, price);


    }

    public void checkIfTableIsEmpty(){

    }

    private void createProduct(String name, String description, String price) {


        homePage.clickOnAddProductButton();

        addProductPage.enterProductName(name);
        addProductPage.enterProductDescription(description);
        addProductPage.enterProductPrice(price);

        addProductPage.clickOnSubmitButton();

        viewProductPage.clickOnHomeButton();

    }

    public void clearUpEnvironment(String name){
        deleteProduct(name);
        Assert.assertFalse(homePage.isProductInList(name));
    }






    @Test(dataProviderClass = EditStaticProvider.class, dataProvider = "testEditProducts")
    public void editProductTest(String name, String description, String price, String editName, String editDescription, String editPrice){



        // EPSU01
        // SETUP: Check whether the `Product` is present in the list, if it's not, create it.
        setUpEnviroment(name, description,price);
        // ASSERT: `Product` in list.
        Assert.assertEquals(homePage.getNameOfLastProductInTheList(), name);

        // EP01
        // Navigate to the `Products Page`
        //Already done in setup
        // ASSERT: We're on the `Products Page` of the Website
        Assert.assertEquals(homePage.getPageUrl(), "products");

        // EP02
        // Click on the `Product` name
        homePage.clickOnProductName(name);
        // ASSERT: We're on the `View Product` page
        Assert.assertEquals(viewProductPage.getPageUrl(), "product-details");

        // EP03
        // Click on the `Edit Product` button
        viewProductPage.clickOnEditButton();
        // ASSERT: We're on the `Edit Product Page`
        Assert.assertEquals(editProductPage.getPageUrl(), "product-edit");

        // EP04
        // Clear the `name`, `description` and `price` fields.
        editProductPage.clickOnNameFieldAndClearIt();
        editProductPage.clickOnDescriptionFieldAndClearIt();
        editProductPage.clickOnPriceFieldAndClearIt();
        // VERIFY: The fields are empty.
        Assert.assertEquals(editProductPage.getTextInNameField(), "");
        Assert.assertEquals(editProductPage.getTextInDescriptionField(), "");
        Assert.assertEquals(editProductPage.getTextInPriceField(), "");

        // EP05
        // Enter new details from the `test-data-edit-product.json` file
        // New details are entered for now we add the details from the EditStaticProvider.java file
        editProductPage.enterProductName(editName);
        editProductPage.enterProductDescription(editDescription);
        editProductPage.enterProductPrice(editPrice);

        // EP06
        // Click on the `Save` button
        editProductPage.clickOnSubmitButton();

        // ASSERT: We are taken to the `View Product` screen
        Assert.assertEquals(viewProductPage.getPageUrl(), "product-details");

        // ASSERT: The `name`, `description` and `price` of the product have been updated.
        Assert.assertEquals(viewProductPage.getProductName(), editName);

        // EP07
        // Click on the `Products Page` button
        viewProductPage.clickOnHomeButton();
        // ASSERT: The `name` and `description` have been updated.
        Assert.assertEquals(homePage.getNamesOfProductsInTheList().get(0), editName);

        // EPTD01
        // TEARDOWN: Delete the `Product` that was created.
        clearUpEnvironment(editName);

        // ASSERT: `Product` is no longer listed.
        Assert.assertFalse(homePage.isProductInList(editName));

    }

    @Test(dataProviderClass = EditStaticProvider.class, dataProvider = "testEditProducts")
    public void viewProductTest(String name, String description, String price){

        //VPSU01
        // SETUP: Check whether the `Product` is present in the list, if it's not, create it.
        setUpEnviroment(name, description, price);
        // ASSERT: `Product` in list.
        Assert.assertEquals(homePage.getNamesOfProductsInTheList(), name);


        // VP01
        // Navigate to the `Products Page`
        // ASSERT: We're on the `Products Page` of the Website

        // VERIFY: The `name` and `description` are correct.

        // VP02
        // Click on the `Product` name
        // ASSERT: We're on the `View Product` page

        // VERIFY: The `name`, `description` and `price` of the product are correct.

        // VPTD01
        // TEARDOWN: Delete the `Product` that was created.
        // ASSERT: `Product` is no longer listed.

    }

}

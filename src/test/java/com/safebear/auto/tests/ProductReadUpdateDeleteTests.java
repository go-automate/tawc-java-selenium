package com.safebear.auto.tests;

import com.safebear.auto.utils.EditStaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductReadUpdateDeleteTests extends BaseTest {


    public void deleteProduct(String name){

        homePage.clickOnProductName(name);
        viewProductPage.clickOnDeleteButton();
    }


    public void setUpEnviroment(String name, String description, String price){

        while(!homePage.isProductInList(name)){

            createProduct(name, description, price);

        }

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



        // Create a product with 'name' (setUpEnvironment)
        setUpEnviroment(name, description,price);


        // Test is to edit it to 'editName' etc...
        homePage.clickOnProductName(name);

        viewProductPage.clickOnEditButton();


        



        // Delete the product with 'editName' (clearUpEnvironment)



    }

}

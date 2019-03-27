package com.safebear.auto.tests;

import com.safebear.auto.utils.EditStaticProvider;
import com.safebear.auto.utils.TestData;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class ProductReadUpdateDeleteTests extends BaseTest {


//    private void deleteProductsInTable(){
//
//
//        while(!homePage.getNamesOfProductsInTheList().isEmpty()){
//
//            homePage.clickOnFirstProductInTable();
//            viewProductPage.clickOnDeleteButton();
//            //viewProductPage.clickOnHomeButton();
//            Assert.assertEquals(homePage.getPageUrl(), "products");
//        }
//
//    }



    @Test(dataProviderClass = EditStaticProvider.class, dataProvider = "testEditProducts")
    public void editProductTest(TestData product){



        // EPSU01
        // SETUP: Check whether the `Product` is present in the list, if it's not, create it.
        rudSetUpEnviroment(product);
        // ASSERT: `Product` in list.
        Assert.assertEquals(homePage.getNameOfLastProductInTheList(), product.getName());

        // EP01
        // Navigate to the `Products Page`
        //Already done in setup
        // ASSERT: We're on the `Products Page` of the Website
        Assert.assertEquals(homePage.getPageUrl(), "products");

        // EP02
        // Click on the `Product` name
        homePage.clickOnProductName(product.getName());
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
        editProductPage.enterProductName(product.getEditName());
        editProductPage.enterProductDescription(product.getEditDescription());
        editProductPage.enterProductPrice(product.getEditPrice());

        // EP06
        // Click on the `Save` button
        editProductPage.clickOnSubmitButton();

        // ASSERT: We are taken to the `View Product` screen
        Assert.assertEquals(viewProductPage.getPageUrl(), "product-details");

        // ASSERT: The `name`, `description` and `price` of the product have been updated.
        Assert.assertEquals(viewProductPage.getProductName(), product.getEditName());

        // EP07
        // Click on the `Products Page` button
        viewProductPage.clickOnHomeButton();
        // ASSERT: The `name` and `description` have been updated.
        List<String> products = homePage.getNamesOfProductsInTheList();

        boolean productInList = false;

        for( String listProduct : products){

            if (listProduct.equals(product.getEditName())){
                productInList = true;
            }

        }

        Assert.assertTrue(productInList, "Product not in the Table");

        // EPTD01
        // TEARDOWN: Delete the `Product` that was created.
        clearUpEnvironment(product);

        // ASSERT: `Product` is no longer listed.
        Assert.assertFalse(homePage.isProductInList(product.getEditName()));

    }

    @Test(dataProviderClass = EditStaticProvider.class, dataProvider = "testEditProducts")
    public void viewProductTest(TestData product){

        //VPSU01
        // SETUP: Check whether the `Product` is present in the list, if it's not, create it.
        rudSetUpEnviroment(product);
        // ASSERT: `Product` in list.
        Assert.assertEquals(homePage.getNameOfLastProductInTheList(), product.getName());


        // VP01
        // Navigate to the `Products Page`
        // ASSERT: We're on the `Products Page` of the Website
        Assert.assertEquals(homePage.getPageUrl(), "products");
        // VERIFY: The `name` and `description` are correct.
        Assert.assertEquals(homePage.getNamesOfProductsInTheList().get(0), product.getName());
        //description can be viewed on the product page

        // VP02
        // Click on the `Product` name
        homePage.clickOnProductName(product.getName());
        // ASSERT: We're on the `View Product` page
        Assert.assertEquals(viewProductPage.getPageUrl(), "product-details");

        // VERIFY: The `name`, `description` and `price` of the product are correct.
        Assert.assertEquals(viewProductPage.getProductName(), product.getName());
        Assert.assertEquals(viewProductPage.getProductDescription(), product.getDescription());
        Assert.assertEquals(viewProductPage.getProductPrice(), product.getPrice());

        // VPTD01
        // TEARDOWN: Delete the `Product` that was created.
        viewProductPage.clickOnDeleteButton();
        // ASSERT: `Product` is no longer listed.
        Assert.assertFalse(homePage.isProductInList(product.getName()));

    }

    @Test(dataProviderClass = EditStaticProvider.class, dataProvider = "testEditProducts" )
    public void deleteProductTest(TestData product){

        // DPSU01
        // SETUP: Check whether the `Product` is listed, if it's not, create it.
        rudSetUpEnviroment(product);
        // ASSERT: `Product` in list.
        Assert.assertEquals(homePage.getNameOfLastProductInTheList(), product.getName());

        // DP01
        // Navigate to the `Products Page`
        // ASSERT: We're on the `Products Page` of the Website
        Assert.assertEquals(homePage.getPageUrl(), "products");

        // DP02
        // Click on the `Product` name
        homePage.clickOnProductName(product.getName());
        // ASSERT: We're on the `View Product` page
        Assert.assertEquals(viewProductPage.getPageUrl(), "product-details");

        // DP03
        // Click on the `Delete Product` button
        viewProductPage.clickOnDeleteButton();
        // ASSERT: We're returned to the `Products Page`
        Assert.assertEquals(homePage.getPageUrl(), "products");

        // ASSERT: The `Product` is no longer listed.
        Assert.assertFalse(homePage.isProductInList(product.getName()));

    }
}

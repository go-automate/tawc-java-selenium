package com.safebear.auto.pages;

import com.safebear.auto.pages.locators.ViewProductPageLocators;
import com.safebear.auto.utils.Utils;

public class ViewProductPage extends BasePage {

    ViewProductPageLocators locators = new ViewProductPageLocators();

    public void clickOnDeleteButton(){
        waitForElement(locators.getDeleteButtonLocator()).click();
    }

    public void clickOnHomeButton(){
        waitForElement(locators.getHomePageButtonLocator()).click();
    }

    public void clickOnEditButton() { waitForElement(locators.getEditButtonLocator()).click(); }

    public String getProductName(){

       return  waitForElement(locators.getProductNameLocator()).getText();

    }

    public String getProductDescription(){

        return waitForElement(locators.getProductDescriptionLocator()).getText();
    }

    public String getProductPrice(){

        return waitForElement(locators.getProductPriceLocator()).getText();
    }



}

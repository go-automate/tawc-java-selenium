package com.safebear.auto.pages;

import com.safebear.auto.pages.locators.EditProductPageLocators;
import com.safebear.auto.utils.Utils;

public class EditProductPage extends BasePage {

    EditProductPageLocators locators = new EditProductPageLocators();

    //public void

    public void clickOnNameFieldAndClearIt() { waitForElement(locators.getNameFieldLocator()).clear();}

    public String getTextInNameField() { return waitForElement(locators.getNameFieldLocator()).getAttribute("value");}

    public void clickOnDescriptionFieldAndClearIt() { waitForElement(locators.getDescripionFieldLocator()).clear();}

    public String getTextInDescriptionField() { return waitForElement(locators.getDescripionFieldLocator()).getAttribute("value");}

    public void clickOnPriceFieldAndClearIt() { waitForElement(locators.getPriceFieldLocator()).clear();}

    public String getTextInPriceField() { return waitForElement(locators.getPriceFieldLocator()).getAttribute("value");}


    public void enterProductName(String name){

        waitForElement(locators.getNameFieldLocator()).sendKeys(name);

    }
    public void enterProductDescription(String description){

        waitForElement(locators.getDescripionFieldLocator()).sendKeys(description);

    }
    public void enterProductPrice(String price){

        waitForElement(locators.getPriceFieldLocator()).sendKeys(price);

    }

    public void clickOnSubmitButton(){ waitForElementToBeEnabled(locators.getSubmitButtonLocator()).click();}




}

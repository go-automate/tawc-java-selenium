package com.safebear.auto.pages;

import com.safebear.auto.pages.locators.EditProductPageLocators;
import com.safebear.auto.utils.Utils;

public class EditProductPage extends BasePage {

    EditProductPageLocators locators = new EditProductPageLocators();

    //public void

    public void clickOnNameFieldAndClearIt() { waitForElement(locators.getNameFieldLocator());}




}

package com.safebear.auto.pages;

import com.safebear.auto.pages.locators.ViewProductPageLocators;
import com.safebear.auto.utils.Utils;

public class ViewProductPage extends Utils {

    ViewProductPageLocators locators = new ViewProductPageLocators();

    public void clickOnDeleteButton(){
        waitForElement(locators.getDeleteButtonLocator()).click();
    }


}

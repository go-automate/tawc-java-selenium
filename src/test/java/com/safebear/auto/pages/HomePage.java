package com.safebear.auto.pages;

import com.safebear.auto.pages.locators.HomePageLocators;
import com.safebear.auto.utils.Utils;
import org.openqa.selenium.WebElement;

public class HomePage extends Utils {

    HomePageLocators locators = new HomePageLocators();


    public void clickOnAddProductButton(){

        waitForElement(locators.getAddProductButtonLocator()).click();

    }

    public String getNameOfLastProductInTheList() {
        return waitForElement(locators.getNameOfLastProductInTable()).getText();
    }


}

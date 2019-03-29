package com.safebear.auto.pages;

import com.safebear.auto.pages.locators.HomePageLocators;
import com.safebear.auto.utils.Utils;
import org.openqa.selenium.WebElement;

import java.util.*;

/**
 * Every action or check we can perform on the HomePage of our app
 */
public class HomePage extends BasePage {

    HomePageLocators locators = new HomePageLocators();

    public boolean areWeOnHomePage(){
        return waitForElement(locators.getPageLocator()).isDisplayed();
    }

    public void clickOnAddProductButton(){

        waitForElement(locators.getAddProductButtonLocator()).click();

    }

    public String getNameOfLastProductInTheList() {
        return waitForElement(locators.getNameOfLastProductInTable()).getText();
    }

    /**
     * NOTE: If there are no products in the table, this method will not fail, it will simply return an empty list.
     * @return List of Strings (names of the products in the table)
     */
    public List<String> getNamesOfProductsInTheList(){

        List<WebElement> elements = waitForElementsNoFail(locators.getProductNamesInTable());

        List<String> names = new ArrayList<>();

        elements.forEach((element) -> {

            names.add(element.getText());

        });

        return names;

    }


    public void clickOnFirstProductInTable(){


        waitForElements(locators.getProductNamesInTable()).get(0).click();

    }


    /**
     * This method allows you to click on the Product Name in the table on the home page.
     * @param name This is the name of the product
     */
    public void clickOnProductName(String name){

        Iterator<WebElement> listOfProductElements = waitForElements(locators.getProductNamesInTable()).iterator();

        while (listOfProductElements.hasNext()) {

            WebElement product = listOfProductElements.next();

            if (product.getText().equals(name)){
                product.click();
                break;
            }

        }

    }

    /**
     * This method iterates through the list and if the parameter string matches any of the Strings in the 'iterator'-list it will return a
     * @param name
     * @return
     */
    public boolean isProductInList(String name) {

        Iterator<String> iterator = this.getNamesOfProductsInTheList().iterator();

        while (iterator.hasNext()) {

            if (iterator.next().equals(name)) {
                return true;
            }
        }

        return false;

    }



}


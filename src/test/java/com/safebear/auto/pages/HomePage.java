package com.safebear.auto.pages;

import com.safebear.auto.pages.locators.HomePageLocators;
import com.safebear.auto.utils.Utils;
import org.openqa.selenium.WebElement;

import java.util.*;

public class HomePage extends BasePage {

    HomePageLocators locators = new HomePageLocators();


    public void clickOnAddProductButton(){

        waitForElement(locators.getAddProductButtonLocator()).click();

    }

    public String getNameOfLastProductInTheList() {
        return waitForElement(locators.getNameOfLastProductInTable()).getText();
    }

    public List<String> getNamesOfProductsInTheList(){

        List<WebElement> elements = waitForElementsNoFail(locators.getProductNamesInTable());

        List<String> names = new ArrayList<>();

        elements.forEach((element) -> {

            names.add(element.getText());

        });

        return names;

    }



    public void clickOnProductName(String name){


        Iterator<WebElement> listOfProductElements = waitForElements(locators.getProductNamesInTable()).iterator();

        List<WebElement> products = waitForElements(locators.getProductNamesInTable());

        while (listOfProductElements.hasNext()) {

            WebElement product = listOfProductElements.next();

            if (product.getText().equals(name)){
                product.click();
                break;
            }

        }

    }

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


package com.safebear.auto.pages.locators;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public class AddProductPageLocators {

    private By pageLocator = By.tagName("app-product-add");

    By homePageButtonLocator = By.cssSelector("a.mat-flat-button.mat-primary");

    By nameFieldLocator = By.cssSelector("[formcontrolname='prod_name']");
    By descripionFieldLocator = By.cssSelector("[formcontrolname='prod_desc']");
    By priceFieldLocator = By.cssSelector("[formcontrolname='prod_price']");

    // By submitButtonLocator = By.cssSelector("button.mat-flat-button.mat-primary");
    By submitButtonLocator = By.cssSelector("[type='submit']");



}

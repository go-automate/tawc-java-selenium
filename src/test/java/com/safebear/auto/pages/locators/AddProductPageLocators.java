package com.safebear.auto.pages.locators;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public class AddProductPageLocators {


    By homePageButtonLocator = By.cssSelector("a.mat-flat-button.mat-primary");

    By nameFieldLocator = By.cssSelector("#mat-input-0");
    By descripionFieldLocator = By.cssSelector("#mat-input-1");
    By priceFieldLocator = By.cssSelector("#mat-input-2");

    By submitButtonLocator = By.cssSelector("button.mat-flat-button.mat-primary");



}

package com.safebear.auto.pages.locators;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public class ViewProductPageLocators {

    private By pageLocator = By.tagName("app-product-detail");

    // Homepage Button
    By homePageButtonLocator = By.cssSelector("div.button-row a.mat-flat-button.mat-primary");

    // Name

    By productNameLocator = By.cssSelector("h2");

    // Description

    By productDescriptionLocator = By.cssSelector("mat-card-subtitle.mat-card-subtitle");

    // Price

    By productPriceLocator = By.cssSelector("mat-card-content.mat-card-content dd:first-of-type");


    // Edit
    By editButtonLocator = By.cssSelector("mat-card-actions a.mat-flat-button.mat-primary");

    // Delete
    By deleteButtonLocator = By.cssSelector("mat-card-actions a.mat-flat-button.mat-warn");



}

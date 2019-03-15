package com.safebear.auto.pages.locators;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public class EditProductPageLocators {

    By viewProductPageButtonLocator = By.cssSelector("a.mat-flat-button.mat-primary");

    By nameFieldLocator = By.cssSelector("#mat-input-6");
    By descripionFieldLocator = By.cssSelector("#mat-input-7");
    By priceFieldLocator = By.cssSelector("#mat-input-8");

    By submitButtonLocator = By.cssSelector("button.mat-flat-button.mat-primary");

}

package com.safebear.auto.pages.locators;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public class HomePageLocators {

    // Locate the app tag that tells us what page we're on
    private By pageLocator = By.tagName("app-products");

    private By addProductButtonLocator = By.cssSelector("a.mat-flat-button.mat-primary");
    private By productNamesInTable = By.cssSelector("td.cdk-column-prod_name");

    // Last product details
    private By nameOfLastProductInTable = By.cssSelector("tbody tr:last-child td:first-child");
    private By nameOfFirstProductInTable = By.cssSelector("tbody tr:first-child td:first-child");
    private By priceOfLastProductInTable = By.cssSelector("tbody tr:last-child td:last-child");

}

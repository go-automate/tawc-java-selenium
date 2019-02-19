package com.safebear.auto.pages;

import com.safebear.auto.pages.locators.LoginPageLocators;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;

@RequiredArgsConstructor
public class LoginPage {


    LoginPageLocators locators = new LoginPageLocators();


    @NonNull
    WebDriver driver;

    public String getPageTitle(){
        return driver.getTitle();
    }
    public void enterUsername(String username){
        driver.findElement(locators.getUsernameLocator()).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(locators.getPasswordLocator()).sendKeys(password);
    }
    public void clicklogButton(){
        driver.findElement(locators.getLoginButtonLocator()).click();
    }
}

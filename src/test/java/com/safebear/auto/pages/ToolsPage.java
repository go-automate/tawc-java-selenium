package com.safebear.auto.pages;

import com.safebear.auto.pages.locators.ToolsPageLocators;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;

@RequiredArgsConstructor
public class ToolsPage {

    ToolsPageLocators locators = new ToolsPageLocators();

    @NonNull
    WebDriver driver;

    public String getPageTitle(){
        return driver.getTitle();
    }
}

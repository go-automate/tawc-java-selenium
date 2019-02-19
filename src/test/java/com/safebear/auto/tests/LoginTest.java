package com.safebear.auto.tests;

import com.safebear.auto.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        // Step 1 ACTION: Open our web application in the browser
        driver.get(Utils.getUrl());

        Assert.assertEquals(loginPage.getPageTitle(), "Login Page" , "The Login Page ddn't open, or the title text has changed");

        loginPage.enterUsername("tester");
        loginPage.enterPassword("letmein");

        loginPage.clicklogButton();

        Assert.assertEquals(toolsPage.getPageTitle(),"Tools Page" , "The Login Page ddn't open, or the title text has changed");
    }

}



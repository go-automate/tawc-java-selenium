package com.safebear.auto.tests;

import com.safebear.auto.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class LoginTest extends BaseTest {
    private SoftAssert softly = new SoftAssert();

    @Test
    public void loginTest() {

        List<List<String>> rows = Utils.getCsvData("src/test/resources/users.csv");
        for (List<String> row : rows ) {

        // Step 1 ACTION: Open our web application in the browser
        driver.get(Utils.getUrl());

        Assert.assertEquals(loginPage.getPageTitle(), "Login Page" , "The Login Page ddn't open, or the title text has changed");

        loginPage.enterUsername(row.get(0));
        loginPage.enterPassword(row.get(1));

        loginPage.clicklogButton();

        Assert.assertEquals(toolsPage.getPageTitle(),"Tools Page" , "The Login Page ddn't open, or the title text has changed");


    }

}
}



package com.safebear.auto.tests;

import com.safebear.auto.utils.Utils;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        // Step 1 ACTION: Open our web application in the browser
        driver.get(Utils.getUrl());
    }
}



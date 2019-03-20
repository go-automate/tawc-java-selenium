package com.safebear.auto.utils;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider(name = "testProducts")
    public static Object[][] createData() {
        return new Object[][] {
                {"chicken", "bird", "350"},
                {"pig", "animal", "500"}
        };
    }



}

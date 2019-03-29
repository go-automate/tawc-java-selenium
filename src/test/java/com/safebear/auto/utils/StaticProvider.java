package com.safebear.auto.utils;

import com.google.common.reflect.TypeToken;
import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.JsonElement;
import gherkin.deps.com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class StaticProvider {

    private static final String FILENAME = System.getProperty("dataset","speed-data.json" );

    @DataProvider(name = "testProducts")
    public static Object[][] createData() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/test-data/" + FILENAME));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<TestData> testData = new Gson().fromJson(dataSet, new TypeToken<List<TestData>>() {
        }.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }




}

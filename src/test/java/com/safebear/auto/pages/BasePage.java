package com.safebear.auto.pages;

import com.safebear.auto.utils.Utils;

import java.util.List;

public class BasePage extends Utils {

    public String getPageUrl(){

        String urlSections[] = browser.getCurrentUrl().split("/");
        return urlSections[3];

    }



}

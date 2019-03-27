package com.safebear.auto.utils;

import lombok.Data;

@Data
public class TestData {

    private String name;
    private String editName;
    private String description;
    private String editDescription;
    private String price;
    private String editPrice;

    @Override
    public String toString() {
        return "TestData{" +
                " name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", editName='" + editName + '\'' +
                ", editDescription='" + editDescription + '\'' +
                ", editPrice='" + editPrice + '\'' +
                '}';

    }
}

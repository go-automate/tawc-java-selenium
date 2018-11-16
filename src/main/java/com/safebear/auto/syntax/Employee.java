package com.safebear.auto.syntax;

public class Employee {

    boolean employed;
    int salary;

    public void fire(){
        employed = false;
    }

    public void employ(){
        employed = true;
    }

    public void givePayRise(){
        salary = salary + 10;
    }
}

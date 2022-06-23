package com.ioana;

public class Wine extends Product {

    private int age;

    public Wine(String name, Double price, Integer stock, Integer age) {
        super(name, price, stock);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
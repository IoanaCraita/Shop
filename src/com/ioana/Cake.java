package com.ioana;

public class Cake extends Product {

    private int calories;
    public Cake(String name, Double price, Integer stock, Integer calories) {
        super(name,price,stock);
        this.calories = calories;
    }


    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }


}

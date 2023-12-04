package com.skilldistillery.jets;

public abstract class Jet {
    private String model;
    private int speed;
    private int range;
    private double price;

    public Jet(String model, int speed, int range, double price) {
        this.model = model;
        this.speed = speed;
        this.range = range;
        this.price = price;
    }

    public abstract void fly();

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    public int getRange() {
        return range;
    }

    public double getPrice() {
        return price;
    }
}

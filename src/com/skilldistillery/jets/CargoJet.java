package com.skilldistillery.jets;

public class CargoJet extends Jet implements CargoCarrier {
    public CargoJet(String model, int speed, int range, double price) {
        super(model, speed, range, price);
    }

    @Override
    public void fly() {
        System.out.println("Cargo jet is flying!");
    }

    @Override
    public void loadCargo() {
        System.out.println("Cargo jet is loading cargo!");
    }
}

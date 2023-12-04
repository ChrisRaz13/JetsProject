package com.skilldistillery.jets;

public class PassengerJet extends Jet {
    public PassengerJet(String model, int speed, int range, double price) {
        super(model, speed, range, price);
    }

    
    public void fly() {
        System.out.println("Passenger jet is flying!");
    }
}

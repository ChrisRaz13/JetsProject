package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {
    public FighterJet(String model, int speed, int range, double price) {
        super(model, speed, range, price);
    }

    public void fly() {
        System.out.println("Fighter jet is flying!");
    }

    public void fight() {
        System.out.println("Fighter jet is ready for combat!");
    }
}

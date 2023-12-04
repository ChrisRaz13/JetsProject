package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {
    public FighterJet(String model, int speed, int range, double price) {
        super(model, speed, range, price);
    }

    @Override
    public void fly() {
        System.out.println("Fighter jet is flying!");
    }

    @Override
    public void fight() {
        System.out.println("Fighter jet is ready for combat!");
    }
}

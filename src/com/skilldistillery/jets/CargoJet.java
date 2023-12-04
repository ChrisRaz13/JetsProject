package com.skilldistillery.jets;

public class CargoJet extends Jet implements CargoCarrier {
	public CargoJet(String model, int speed, int range, double price) {
		super(model, speed, range, price);
	}

	public void fly() {
		System.out.println("Cargo jet is flying!");
	}

	public void loadCargo() {
		System.out.println("Cargo jet is loading cargo!");
	}
}

package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication { 
    private static AirField airField = new AirField();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        populateAirField();

        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    listFleet();
                    break;
                case 2:
                    flyAllJets();
                    break;
                case 3:
                    viewFastestJet();
                    break;
                case 4:
                    viewLongestRangeJet();
                    break;
                case 5:
                    loadAllCargoJets();
                    break;
                case 6:
                    dogfight();
                    break;
                case 7:
                    addJetToFleet();
                    break;
                case 8:
                    removeJetFromFleet();
                    break;
                case 9:
                    // Quit the program
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);

        System.out.println("Exiting the program.");
    }

    private static void populateAirField() {
        airField.addJet(new CargoJet("C-17 Globemaster III", 950, 6200, 340000000));
        airField.addJet(new CargoJet("C-47 Skytrain", 370, 1600, 350000));
        airField.addJet(new FighterJet("F-16 Fighting Falcon", 1345, 500, 63000000));
        airField.addJet(new FighterJet("F-35 Lightning II", 1200, 1200, 78000000));
        airField.addJet(new PassengerJet("Boeing 757", 982, 4000, 7000000));
    }

    private static void displayMenu() {
        System.out.println("1. List Fleet");
        System.out.println("2. Fly All Jets");
        System.out.println("3. View Fastest Jet");
        System.out.println("4. View Jet with Longest Range");
        System.out.println("5. Load All Cargo Jets");
        System.out.println("6. Dogfight!");
        System.out.println("7. Add a Jet to Fleet");
        System.out.println("8. Remove a Jet from Fleet");
        System.out.println("9. Quit");
        System.out.print("Enter your choice: ");
    }

    private static void listFleet() {
        System.out.println("===== List of Jets =====");
        for (int i = 0; i < airField.getJets().size(); i++) {
            Jet jet = airField.getJets().get(i);
            System.out.printf("%d. %s - Speed: %d MPH, Range: %d miles, Price: $%.2f%n",
                    i + 1, jet.getModel(), jet.getSpeed(), jet.getRange(), jet.getPrice());
        }
    }

    private static void flyAllJets() {
        System.out.println("===== Flying All Jets =====");
        for (Jet jet : airField.getJets()) {
            jet.fly();
        }
    }

    private static void viewFastestJet() {
        Jet fastestJet = findFastestJet();
        displayJetDetails("Fastest Jet", fastestJet);
    }

    private static void viewLongestRangeJet() {
        Jet longestRangeJet = findLongestRangeJet();
        displayJetDetails("Jet with Longest Range", longestRangeJet);
    }

    private static void loadAllCargoJets() {
        System.out.println("===== Loading All Cargo Jets =====");
        for (Jet jet : airField.getJets()) {
            if (jet instanceof CargoCarrier) {
                ((CargoCarrier) jet).loadCargo();
            }
        }
    }

    private static void dogfight() {
        System.out.println("===== Initiating Dogfight! =====");
        for (Jet jet : airField.getJets()) {
            if (jet instanceof CombatReady) {
                ((CombatReady) jet).fight();
            }
        }
    }

    private static void addJetToFleet() {
        System.out.println("===== Adding a Jet to Fleet =====");
        System.out.print("Enter Jet model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Jet speed (in MPH): ");
        int speed = scanner.nextInt();
        System.out.print("Enter Jet range: ");
        int range = scanner.nextInt();
        System.out.print("Enter Jet price: ");
        double price = scanner.nextDouble();

        System.out.println("Choose Jet type:");
        System.out.println("1. Passenger Jet");
        System.out.println("2. Cargo Jet");
        System.out.println("3. Fighter Jet");
        System.out.print("Enter your choice: ");
        int jetType = scanner.nextInt();
        scanner.nextLine(); 

        Jet newJet;
        switch (jetType) {
            case 1:
                newJet = new PassengerJet(model, speed, range, price);
                break;
            case 2:
                newJet = new CargoJet(model, speed, range, price);
                break;
            case 3:
                newJet = new FighterJet(model, speed, range, price);
                break;
            default:
                System.out.println("Invalid choice. Creating a Passenger Jet by default.");
                newJet = new PassengerJet(model, speed, range, price);
        }

        airField.addJet(newJet);
        System.out.println("Jet added to the fleet!");
    }

    private static void removeJetFromFleet() {
        System.out.println("===== Removing a Jet from Fleet =====");
        System.out.print("Enter the number of the Jet to remove: ");
        int jetNumber = scanner.nextInt();
        airField.removeJet(jetNumber - 1);
        System.out.println("Jet removed from the fleet!");
    }

    private static void displayJetDetails(String title, Jet jet) {
        if (jet != null) {
            System.out.printf("===== %s =====%n", title);
            System.out.printf("Model: %s%n", jet.getModel());
            System.out.printf("Speed: %d MPH%n", jet.getSpeed());
            System.out.printf("Range: %d miles%n", jet.getRange());
            System.out.printf("Price: $%.2f%n", jet.getPrice());
        } else {
            System.out.println("No Jets available.");
        }
    }

    private static Jet findFastestJet() {
        Jet fastestJet = null;
        int maxSpeed = Integer.MIN_VALUE;

        for (Jet jet : airField.getJets()) {
            if (jet.getSpeed() > maxSpeed) {
                maxSpeed = jet.getSpeed();
                fastestJet = jet;
            }
        }

        return fastestJet;
    }

    private static Jet findLongestRangeJet() {
        Jet longestRangeJet = null;
        int maxRange = Integer.MIN_VALUE;

        for (Jet jet : airField.getJets()) {
            if (jet.getRange() > maxRange) {
                maxRange = jet.getRange();
                longestRangeJet = jet;
            }
        }

        return longestRangeJet;
    }
}

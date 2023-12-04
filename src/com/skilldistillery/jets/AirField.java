package com.skilldistillery.jets;

import java.util.ArrayList;
import java.util.List;

public class AirField {
    private List<Jet> jets;

    public AirField() {
        this.jets = new ArrayList<>();
    }

    public List<Jet> getJets() {
        return jets;
    }

    public void addJet(Jet jet) {
        jets.add(jet);
    }

    public void removeJet(int index) {
        if (index >= 0 && index < jets.size()) {
            jets.remove(index);
        } else {
            System.out.println("Invalid index. No jet removed.");
        }
    }
}

package org.BeziehungenVererbung.Mitarbeiter.model;

public class Manager extends BüroArbeiter {
    private double bonusProzent;

    public Manager(int id, String name, double festgehalt, double bonusProzent) {
        super(id, name, festgehalt);
        this.bonusProzent = bonusProzent;
    }

    @Override
    public double berechneGehalt() {
        return super.berechneGehalt() + (super.berechneGehalt() * bonusProzent / 100);
    }
}

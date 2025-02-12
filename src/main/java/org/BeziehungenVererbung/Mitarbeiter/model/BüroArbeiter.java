package org.BeziehungenVererbung.Mitarbeiter.model;

public class BüroArbeiter extends Mitarbeiter {
    private double festgehalt;

    public BüroArbeiter(int id, String name, double festgehalt) {
        super(id, name);
        if (!String.valueOf(id).startsWith("5")) {
            throw new IllegalArgumentException("Büroarbeiter-IDs müssen mit 5 beginnen.");
        }
        this.festgehalt = festgehalt;
    }

    @Override
    public double berechneGehalt() {
        return festgehalt;
    }
}

package org.KreisUndRechteck.entity;

public class Rechteck extends Form {
    private float hoehe;
    private float breite;

    public Rechteck(float hoehe, float breite) {
        super("Rechteck", 0, hoehe, breite);
        this.hoehe = hoehe;
        this.breite = breite;
    }

    @Override
    public void berechneFlaeche(float radius, float hoehe, float breite) {
        this.flaeche = hoehe * breite;
        this.umfang = 2 * (hoehe + breite);
    }
}

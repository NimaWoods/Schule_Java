package org.KreisUndRechteck.entity;

public class Dreieck extends Form {

    public Dreieck(float hoehe, float breite) {
        super("Dreieck", 0, hoehe, breite);
    }

    @Override
    public void berechneFlaeche(float radius, float hoehe, float breite) {
        this.flaeche = (float) (0.5 * breite * hoehe);
        this.umfang = breite + 2 * (float) Math.sqrt((breite * breite) + (hoehe * hoehe));
    }
}

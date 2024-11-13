package org.KreisUndRechteck;

public class Rechteck {

    public float hoehe;
    public float breite;

    public Rechteck(float hoehe, float breite) {
        this.hoehe = hoehe;
        this.breite = breite;
    }

    public float berechneFlaeche() {
        return hoehe * breite;
    }

    public float berechneUmfang() {
        return 2 * (hoehe + breite);
    }
}

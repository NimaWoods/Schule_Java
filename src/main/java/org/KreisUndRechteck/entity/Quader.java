package org.KreisUndRechteck.entity;

public class Quader extends Form3D {
    private float laenge;
    private float breite;
    private float hoehe;

    public Quader(float laenge, float breite, float hoehe) {
        super("Quader");
        this.laenge = laenge;
        this.breite = breite;
        this.hoehe = hoehe;
    }

    @Override
    public void berechneVolumen() {
        this.volumen = laenge * breite * hoehe;
    }

    @Override
    public void berechneOberflaeche() {
        this.oberflaeche = 2 * (laenge * breite + breite * hoehe + laenge * hoehe);
    }
}

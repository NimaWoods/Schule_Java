package org.KreisUndRechteck.entity;

import org.KreisUndRechteck.enums.FormTyp;

public class Quader extends Figur3D {
    private float laenge;
    private float breite;
    private float hoehe;

    public Quader(float laenge, float breite, float hoehe) {
        super(FormTyp.Quader);
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

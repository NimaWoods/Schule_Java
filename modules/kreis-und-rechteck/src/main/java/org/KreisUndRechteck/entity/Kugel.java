package org.KreisUndRechteck.entity;

import org.KreisUndRechteck.enums.FormTyp;

public class Kugel extends Figur3D {
    private float radius;

    public Kugel(float radius) {
        super(FormTyp.Kugel);
        this.radius = radius;
    }

    @Override
    public void berechneVolumen() {
        this.volumen = (float) (4/3.0 * Math.PI * (radius * radius * radius));
    }

    @Override
    public void berechneOberflaeche() {
        this.oberflaeche = (float) (4 * Math.PI * (radius * radius));
    }
}
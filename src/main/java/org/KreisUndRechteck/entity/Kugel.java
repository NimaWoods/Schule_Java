package org.KreisUndRechteck.entity;

public class Kugel extends Form3D {
    private float radius;

    public Kugel(float radius) {
        super("Kugel");
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
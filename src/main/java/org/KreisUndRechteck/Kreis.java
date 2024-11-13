package org.KreisUndRechteck;



public class Kreis {

    public float radius;

    public Kreis(float radius) {
        this.radius = radius;
    }

    public float berechneFlaeche() {
        return (float) (Math.PI * (radius * radius));
    }

    public float berechneUmfang() {
        return (float) (2 * Math.PI * radius);
    }
}

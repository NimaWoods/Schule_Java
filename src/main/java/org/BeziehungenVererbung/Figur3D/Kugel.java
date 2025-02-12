package org.BeziehungenVererbung.Figur3D;

public class Kugel extends Figur3D {
    private final double radius;

    public Kugel(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius muss positiv sein.");
        }
        this.radius = radius;
    }

    @Override
    public double berechneVolumen() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public double berechneOberfläche() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }
}

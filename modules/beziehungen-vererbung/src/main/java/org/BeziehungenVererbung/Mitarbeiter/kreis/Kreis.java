package org.BeziehungenVererbung.Mitarbeiter.kreis;

public class Kreis {
    private double radius;

    public Kreis(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Der Radius muss positiv sein.");
        }
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }
    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Der Radius muss positiv sein.");
        }
        this.radius = radius;
    }

    public double flaeche() {
        return this.radius * this.radius * Math.PI;
    }

    public double umfang() {
        return 2 * this.radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Kreis mit Radius: " + this.radius + ", Fläche: " + flaeche() + ", Umfang: " + umfang();
    }
}
package org.KreisUndRechteck.entity;

public class Kreis extends Form {
    private float radius;

    public Kreis(float radius) {
        super("Kreis", radius, 0, 0);
        this.radius = radius;
    }

    @Override
    public void berechneFlaeche(float radius, float hoehe, float breite) {
        this.flaeche = (float) (Math.PI * (radius * radius));
        this.umfang = (float) (2 * Math.PI * radius);
    }
}

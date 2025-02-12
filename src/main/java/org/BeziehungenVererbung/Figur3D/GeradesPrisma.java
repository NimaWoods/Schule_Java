package org.BeziehungenVererbung.Figur3D;

public class GeradesPrisma extends Figur3D {
    private final double grundfläche;
    private final double höhe;
    private final double umfang;

    public GeradesPrisma(double grundfläche, double höhe, double umfang) {
        if (grundfläche <= 0 || höhe <= 0 || umfang <= 0) {
            throw new IllegalArgumentException("Grundfläche, Höhe und Umfang müssen positiv sein.");
        }
        this.grundfläche = grundfläche;
        this.höhe = höhe;
        this.umfang = umfang;
    }

    @Override
    public double berechneVolumen() {
        return grundfläche * höhe;
    }

    @Override
    public double berechneOberfläche() {
        return 2 * grundfläche + umfang * höhe;
    }
}

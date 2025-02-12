package org.interfaced;

public class Dreieck implements INamed {
    private double seiteA;
    private double seiteB;
    private double seiteC;

    public Dreieck(double seiteA, double seiteB, double seiteC) {
        if (!isKonstruierbar(seiteA, seiteB, seiteC)) {
            throw new IllegalArgumentException("Dreieck ist nicht konstruierbar!");
        }
        this.seiteA = seiteA;
        this.seiteB = seiteB;
        this.seiteC = seiteC;
    }

    public void setSeiteA(double seiteA) {
        if (!isKonstruierbar(seiteA, this.seiteB, this.seiteC)) {
            throw new IllegalArgumentException("Dreieck ist nicht konstruierbar!");
        }
        this.seiteA = seiteA;
    }

    public void setSeiteB(double seiteB) {
        if (!isKonstruierbar(this.seiteA, seiteB, this.seiteC)) {
            throw new IllegalArgumentException("Dreieck ist nicht konstruierbar!");
        }
        this.seiteB = seiteB;
    }

    public void setSeiteC(double seiteC) {
        if (!isKonstruierbar(this.seiteA, this.seiteB, seiteC)) {
            throw new IllegalArgumentException("Dreieck ist nicht konstruierbar!");
        }
        this.seiteC = seiteC;
    }

    public static boolean isKonstruierbar(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    @Override
    public String name() {
        return "Dreieck mit Seitenlängen " + seiteA + ", " + seiteB + ", " + seiteC;
    }
}

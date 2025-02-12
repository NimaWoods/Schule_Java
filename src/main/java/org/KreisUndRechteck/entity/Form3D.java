package org.KreisUndRechteck.entity;

public abstract class Form3D {

    public float getVolumen() {
        return volumen;
    }

    public void setVolumen(float volumen) {
        this.volumen = volumen;
    }

    public float getOberflaeche() {
        return oberflaeche;
    }

    public void setOberflaeche(float oberflaeche) {
        this.oberflaeche = oberflaeche;
    }

    float volumen = 0.0F;
    float oberflaeche = 0.0F;

    String form;

    public Form3D(String form) {
        this.form = form;
    }

    public abstract void berechneVolumen();
    public abstract void berechneOberflaeche();
}
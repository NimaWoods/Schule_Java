package org.KreisUndRechteck.entity;

public abstract class Form {

    public float getFlaeche() {
        return flaeche;
    }

    public void setFlaeche(float flaeche) {
        this.flaeche = flaeche;
    }

    public float getUmfang() {
        return umfang;
    }

    public void setUmfang(float umfang) {
        this.umfang = umfang;
    }

    float flaeche = 0.0F;
    float umfang = 0.0F;

    String form;

    public Form(String form, float radius, float hoehe, float breite) {
        this.form = form;
    }

    public abstract void berechneFlaeche(float radius, float hoehe, float breite);
}

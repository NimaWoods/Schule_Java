package org.KreisUndRechteck;

import java.util.Map;

public class Form {

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

        berechneFlaeche(radius, hoehe, breite);
    }

    public void berechneFlaeche(float radius, float hoehe, float breite) {

        switch (form) {
            case "Kreis":
                Kreis kreis = new Kreis(5);
                this.flaeche = kreis.berechneFlaeche();
                this.umfang = kreis.berechneUmfang();
                break;
            case "Rechteck":
                Rechteck rechteck = new Rechteck(5, 10);
                this.flaeche = rechteck.berechneFlaeche();
                this.umfang = rechteck.berechneUmfang();
                break;
            default:
                System.out.println("Form nicht bekannt");
        }
    }

}

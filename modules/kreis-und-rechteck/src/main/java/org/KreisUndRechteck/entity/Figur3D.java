package org.KreisUndRechteck.entity;

import org.KreisUndRechteck.enums.FormTyp;

public abstract class Figur3D {

    float volumen = 0.0F;
    float oberflaeche = 0.0F;

    FormTyp form;

    public Figur3D(FormTyp form) {
        this.form = form;
    }

    public float getVolumen() {
        if(volumen == 0.0F) {
            berechneVolumen();
        }
        return volumen;
    }

    public float getOberflaeche() {
        if(oberflaeche == 0.0F) {
            berechneOberflaeche();
        }
        return oberflaeche;
    }

    public String toCSVString() {
        return form + ";" + volumen + ";" + oberflaeche;
    }

    public abstract void berechneVolumen();
    public abstract void berechneOberflaeche();
}
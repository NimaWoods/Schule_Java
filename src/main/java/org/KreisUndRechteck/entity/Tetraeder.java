package org.KreisUndRechteck.entity;

import org.KreisUndRechteck.enums.FormTyp;

public class Tetraeder extends Figur3D {
	private float seite;

	public Tetraeder(float seite) {
		super(FormTyp.Tetraeder);
		this.seite = seite;
	}

	@Override
	public void berechneVolumen() {
		this.volumen = (float) (seite * seite * seite / (6 * Math.sqrt(2)));
	}

	@Override
	public void berechneOberflaeche() {
		this.oberflaeche = (float) (Math.sqrt(3) * seite * seite);
	}
}
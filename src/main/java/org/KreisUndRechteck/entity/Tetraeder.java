package org.KreisUndRechteck.entity;

public class Tetraeder extends Form3D {
	private float seite;

	public Tetraeder(float seite) {
		super("Tetraeder");
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
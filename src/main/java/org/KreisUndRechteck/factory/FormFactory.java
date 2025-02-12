package org.KreisUndRechteck.factory;

import org.KreisUndRechteck.entity.Dreieck;
import org.KreisUndRechteck.entity.Form;
import org.KreisUndRechteck.entity.Kreis;
import org.KreisUndRechteck.entity.Rechteck;

public class FormFactory {
	public static Form erstelleForm(String formTyp, float radius, float hoehe, float breite) {
		switch (formTyp) {
		case "Kreis":
			return new Kreis(radius);
		case "Rechteck":
			return new Rechteck(hoehe, breite);
		case "Dreieck":
			return new Dreieck(breite, radius);
		default:
			System.out.println("Form nicht bekannt");
			return null;
		}
	}
}

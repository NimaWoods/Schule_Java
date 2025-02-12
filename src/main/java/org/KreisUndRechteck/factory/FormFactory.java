package org.KreisUndRechteck.factory;

import org.KreisUndRechteck.entity.Form3D;
import org.KreisUndRechteck.entity.Kugel;
import org.KreisUndRechteck.entity.Quader;
import org.KreisUndRechteck.entity.Tetraeder;

public class FormFactory {
	public static Form3D erstelleForm3D(String formTyp, float... parameter) {
		switch (formTyp) {
		case "Kugel":
			return new Kugel(parameter[0]);
		case "Quader":
			return new Quader(parameter[0], parameter[1], parameter[2]);
		case "Tetraeder":
			return new Tetraeder(parameter[0]);
		default:
			throw new IllegalArgumentException("Ungueltiger Formtyp");
		}
	}
}

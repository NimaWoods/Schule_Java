package org.KreisUndRechteck;

import org.KreisUndRechteck.entity.Dreieck;
import org.KreisUndRechteck.entity.Kreis;
import org.KreisUndRechteck.entity.Rechteck;
import org.KreisUndRechteck.factory.FormFactory;

public class Main {
    public static void main(String[] args) {
        Kreis kreis = (Kreis) FormFactory.erstelleForm("Kreis", 5, 10, 15);
        Rechteck rechteck = (Rechteck) FormFactory.erstelleForm("Rechteck", 5, 10, 15);
        Dreieck dreieck = (Dreieck) FormFactory.erstelleForm("Dreieck", 5, 10, 15);

		if (kreis != null) {
			kreis.berechneFlaeche(5, 0, 0);
            System.out.println("Kreis-Fläche: " + kreis.getFlaeche());
		}
		if (rechteck != null) {
			rechteck.berechneFlaeche(0, 5, 10);
            System.out.println("Rechteck-Fläche: " + rechteck.getFlaeche());
		}
		if (dreieck != null) {
			dreieck.berechneFlaeche(0, 5, 10);
            System.out.println("Dreieck-Fläche: " + dreieck.getFlaeche());
        }
    }
}

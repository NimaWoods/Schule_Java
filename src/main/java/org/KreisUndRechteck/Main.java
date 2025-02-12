package org.KreisUndRechteck;

import org.KreisUndRechteck.entity.Form3D;
import org.KreisUndRechteck.factory.FormFactory;

public class Main {
	public static void main(String[] args) {
		Form3D kugel = FormFactory.erstelleForm3D("Kugel", 5);
		Form3D quader = FormFactory.erstelleForm3D("Quader", 5, 10, 15);
		Form3D tetraeder = FormFactory.erstelleForm3D("Tetraeder", 5);

		kugel.berechneVolumen();
		kugel.berechneOberflaeche();
		System.out.println("Kugel-Volumen: " + kugel.getVolumen());
		System.out.println("Kugel-Oberfläche: " + kugel.getOberflaeche());

		quader.berechneVolumen();
		quader.berechneOberflaeche();
		System.out.println("Quader-Volumen: " + quader.getVolumen());
		System.out.println("Quader-Oberfläche: " + quader.getOberflaeche());

		tetraeder.berechneVolumen();
		tetraeder.berechneOberflaeche();
		System.out.println("Tetraeder-Volumen: " + tetraeder.getVolumen());
		System.out.println("Tetraeder-Oberfläche: " + tetraeder.getOberflaeche());
	}
}

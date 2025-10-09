package org.KreisUndRechteck;

import static org.KreisUndRechteck.enums.FormTyp.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.KreisUndRechteck.entity.Figur3D;
import org.KreisUndRechteck.factory.FormFactory;
import org.KreisUndRechteck.utils.CSVUtil;

public class Main {
	public static void main(String[] args) {
		List<Figur3D> figuren = new ArrayList<>();

		Figur3D kugel = FormFactory.erstelleForm3D(Kugel, 5, 10, 15);
		Figur3D quader = FormFactory.erstelleForm3D(Quader, 5, 10, 15);
		Figur3D tetraeder = FormFactory.erstelleForm3D(Tetraeder, 5, 10, 15);

		kugel.berechneVolumen();
		kugel.berechneOberflaeche();

		quader.berechneVolumen();
		quader.berechneOberflaeche();

		tetraeder.berechneVolumen();
		tetraeder.berechneOberflaeche();

		figuren.add(kugel);
		figuren.add(quader);
		figuren.add(tetraeder);

		CSVUtil.writeAll(figuren, Path.of("figuren.csv"));
		List<Figur3D> geleseneFiguren = CSVUtil.readALl(Path.of("figuren.csv"));

		for(Figur3D f: geleseneFiguren) {
			System.out.println( "-Volumen: " + f.getVolumen());
			System.out.println("Kugel-Oberfläche: " + f.getOberflaeche());
		}

	}
}

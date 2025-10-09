package org.KreisUndRechteck.utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.logging.Logger;

import org.KreisUndRechteck.entity.Figur3D;
import org.KreisUndRechteck.enums.FormTyp;
import org.KreisUndRechteck.factory.FormFactory;

public class CSVUtil {

	public static void writeAll(List<Figur3D> figs, Path p) {

		Logger logger = Logger.getLogger(CSVUtil.class.getName());

		try (BufferedWriter bw = Files.newBufferedWriter(p, StandardOpenOption.CREATE)) {
			for(Figur3D f: figs) {
				bw.write(f.toCSVString());
				bw.write("\n");
			}
		} catch (IOException e) {
			logger.severe("Fehler beim Schreiben der CSV-Datei: " + e.getMessage());
		}
	}

	public static List<Figur3D> readALl(Path path) {
		Logger logger = Logger.getLogger(CSVUtil.class.getName());
		List<Figur3D> figs = null;

		try {
			List<String> lines = Files.readAllLines(path);
			for(String line: lines) {
				String[] parts = line.split(";");

				Figur3D figur3D = FormFactory.erstelleForm3D(
						FormTyp.fromString(parts[0]),
						Float.parseFloat(parts[1]),
						Float.parseFloat(parts[2]),
						Float.parseFloat(parts[3])
				);
				figs.add(figur3D);
			}
		} catch (IOException e) {
			logger.severe("Fehler beim Lesen der CSV-Datei: " + e.getMessage());
		}
		return figs;
	}
}

package org.Materialpreis;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaterialFactory {

	private static final Logger LOGGER = Logger.getLogger(MaterialFactory.class.getName());

	public static List<Material> createMaterialsFromCSV(File file, String unit) {
		List<Material> materials = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(";");
				if (values.length >= 2) {
					String name = values[0].trim();
					try {
						double price = Double.parseDouble(values[1].trim().replace(",", "."));
						materials.add(new Material(name, price, unit));
					} catch (NumberFormatException e) {
						LOGGER.log(Level.WARNING, "Fehler beim Parsen des Preises: {0}", values[1]);
					}
				}
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Fehler beim Lesen der Datei: " + file.getAbsolutePath(), e);
		}
		return materials;
	}

	public static void updateAndSaveCSV(File file, List<Material> materials) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			for (Material material : materials) {
				bw.write(material.getName() + ";" + material.getPrice());
				bw.newLine();
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Fehler beim Schreiben der Datei: " + file.getAbsolutePath(), e);
		}
	}

	public static void saveOrders(List<Material> materials) {
		File file = new File("Bestellungen.csv");
		LOGGER.info("Speichere Datei unter: " + file.getAbsolutePath());

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
			for (Material material : materials) {
				String line = material.getName() + ";" + material.getPrice() + ";" + material.getUnit() + ";"
						+ material.getAmount() + ";" + material.getTotal();
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Fehler beim Speichern der Bestellungen", e);
		}
	}

	public static void deleteOrder(Material material) {
		File file = new File("Bestellungen.csv");
		File tempFile = new File("temp.csv");

		try (BufferedReader br = new BufferedReader(new FileReader(file));
				BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.startsWith(material.getName() + ";")) {
					bw.write(line);
					bw.newLine();
				}
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Fehler beim Löschen der Bestellung für: " + material.getName(), e);
		}

		try {
			Files.move(tempFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Fehler beim Ersetzen der Originaldatei", e);
		}
	}
}

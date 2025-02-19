package org.Materialpreis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		start();
	}

	public static void start() {
		List<Material> materialsFuellung = null;
		List<Material> materialsOberflaechen = null;

		materialsFuellung = getMaterial(new File("Materialpreise Fuellung.csv"), "m²");
		materialsOberflaechen = getMaterial(new File("Materialpreise Oberflaechen.csv"), "m³");

		List<Material> materials = new ArrayList<>();
		if (materialsFuellung != null && materialsOberflaechen != null) {
			materials.addAll(materialsFuellung);
			materials.addAll(materialsOberflaechen);
		}

		materials.sort(Comparator.comparing(Material::getName));

		Material material = ComboBoxUserConsoleInput.getUserSelection("Wähle ein Material: ", materials);

		Scanner scanner = new Scanner(System.in);

		System.out.print("Bitte gib die benötigte Menge in " + material.getUnit() + " ein: ");

		double amount = scanner.nextDouble();
		double price = calculatePrice(material, amount);

		scanner.nextLine(); // Consume newline left-over

		System.out.println(" ");
		System.out.println("Der Gesamtpreis für " + amount + material.getUnit() + " " + material.getName() + " beträgt: " + price + "€");
		System.out.println(" ");
		System.out.println(" ");
		System.out.print("Möchtest du eine weitere Berechnung durchführen? (y/n)");

		if (!scanner.nextLine().equalsIgnoreCase("n")) {
			start();
		} else {
			System.out.println("Programm beendet.");
		}
	}

	private static List<Material> getMaterial(File file, String unit) {
		try {
			List<List<String>> records = readCSV(file);

			List<Material> materials = new ArrayList<>();

			for (List<String> record : records) {
				String name = record.get(0);
				double price = Double.parseDouble(record.get(1).replace(",", "."));

				materials.add(new Material(name, price, unit));
			}

			return materials;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static List<List<String>> readCSV(File file) {
		List<List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(";");
				records.add(Arrays.asList(values));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return records;
	}

	private static double calculatePrice(Material material, double doubleInput) {
		if (Objects.equals(material.getUnit(), "m²")) {
			return material.getPrice() * doubleInput;
		} else {
			return material.getPrice() * doubleInput * 2;
		}
	}

}


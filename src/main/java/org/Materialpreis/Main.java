package org.Materialpreis;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

	private static final List<Material> materialsOrders = new ArrayList<>();

	public static void main(String[] args) {
		start();
	}

	public static void start() {
		List<Material> materialsFuellung = null;
		List<Material> materialsOberflaechen = null;

		materialsFuellung = MaterialFactory.createMaterialsFromCSV(new File("Materialpreise Fuellung.csv"), "m²");
		materialsOberflaechen = MaterialFactory.createMaterialsFromCSV(new File("Materialpreise Oberflaechen.csv"), "m³");

		List<Material> materials = new ArrayList<>();

		materials.addAll(materialsFuellung);
		materials.addAll(materialsOberflaechen);

		materials.sort(Comparator.comparing(Material::getName));

		Material material = ComboBoxUserConsoleInput.getUserSelection("Wähle ein Material: ", materials);
		materialsOrders.add(material);

		Scanner scanner = new Scanner(System.in);

		System.out.print("Bitte gib die benötigte Menge in " + material.getUnit() + " ein: ");

		double amount = scanner.nextDouble();
		double price = calculatePrice(material, amount);

		scanner.nextLine(); // Consume newline left-over

		System.out.println(" ");
		System.out.println("Der Gesamtpreis für " + amount + material.getUnit() + " " + material.getName() + " beträgt: " + price + "€");
		System.out.println(" ");
		System.out.println(" ");
		System.out.print("Möchtest du eine weitere Bestellung durchführen? (y/n)");

		if (!scanner.nextLine().equalsIgnoreCase("n")) {
			start();
		} else {
			MaterialFactory.saveOrders(materialsOrders);
			System.out.println("Bestellungen wurden gespeichert.");
		}
	}

	private static double calculatePrice(Material material, double doubleInput) {
		if (Objects.equals(material.getUnit(), "m²")) {
			return material.getPrice() * doubleInput;
		} else {
			return material.getPrice() * doubleInput * 2;
		}
	}

}


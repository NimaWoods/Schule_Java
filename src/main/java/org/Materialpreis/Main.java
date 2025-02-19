import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		List<Material> materialsFuellung = getMaterial(new File("Materialpreise Fuellung.csv"));
		List<Material> materialsOberflaechen = getMaterial(new File("Materialpreise Oberflaechen.csv"));

		List<Material> materials = new ArrayList<>();
		if (materialsFuellung != null && materialsOberflaechen != null) {
			materials.addAll(materialsFuellung);
			materials.addAll(materialsOberflaechen);
		}

		materials.sort(Comparator.comparing(Material::getName));

		Material material = ComboBoxUserConsoleInput.getUserSelection("Wähle ein Material: ", materials);

		Scanner scanner = new Scanner(System.in);
		double price = 0;
		if (materialsFuellung.contains(material)) {
			System.out.print("Bitte gib die Fläche der Füllung in m² ein: ");
			Double input = scanner.nextDouble();

			price = calculatePrice(material, input, true);
		} else {
			System.out.print("Bitte gib das Volumen der Oberfläche in m³ ein: ");
			Double input = scanner.nextDouble();

			price = calculatePrice(material, input, false);
		}

		System.out.println("Der Preis beträgt: " + price + "€");
	}

	private static List<Material> getMaterial(File file) {
		try {
			List<List<String>> records = readCSV(file);

			List<Material> materials = new ArrayList<>();

			for (List<String> record : records) {
				String name = record.get(0);
				double price = Double.parseDouble(record.get(1));

				materials.add(new Material(name, price));
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

	private static double calculatePrice(Material material, double doubleInput, boolean isFuellung) {
		if (isFuellung) {
			return material.getPrice() * doubleInput;
		} else {
			return material.getPrice() * doubleInput * 2;
		}
	}

}


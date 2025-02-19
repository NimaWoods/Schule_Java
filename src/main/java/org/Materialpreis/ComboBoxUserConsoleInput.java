import java.util.List;
import java.util.Scanner;

public class ComboBoxUserConsoleInput {

	public static <T> T getUserSelection(String message, List<T> options) {
		Scanner scanner = new Scanner(System.in);
		int choice = -1;

		while (choice < 1 || choice > options.size()) {
			System.out.println(message);
			for (int i = 0; i < options.size(); i++) {
				System.out.println((i + 1) + ") " + options.get(i));
			}
			System.out.print("Bitte wählen (1-" + options.size() + "): ");

			if (scanner.hasNextInt()) {
				choice = scanner.nextInt();
			} else {
				scanner.next();
			}
		}

		return options.get(choice - 1);
	}

}

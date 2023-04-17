import java.util.Scanner;

public class ValidatorIO {

	public static int getInt(Scanner sc, String promt) {
		int input = 0;
		boolean isValid = false;

		while (!isValid) {
			System.out.println(promt);

			if (sc.hasNextInt()) {
				input = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer value.");
			}
			sc.nextLine();
		}
		return input;
	}

	public static double getDouble(Scanner sc, String promt) {
		double input = 0;
		boolean isValid = false;

		while (!isValid) {
			System.out.println(promt);

			if (sc.hasNextDouble()) {
				input = sc.nextDouble();
				isValid = true;
			} else {
				System.out.println("Error! Invalid double value.");
			}
			sc.nextLine();
		}
		return input;
	}

	public static String getString(Scanner sc, String promt) {

		System.out.println(promt);
		return sc.next();

	}
}

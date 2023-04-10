
import java.util.ArrayList;
import java.util.Scanner;

public class TestBowlingShopApp {

	public static void main(String[] args) {

		System.out.println("MENU OPTIONS");
		System.out.println("1. <b> Bowling Balls");
		System.out.println("2. <a> Bowling Bags");
		System.out.println("3. <s> Bowling Shoes");
		System.out.println("4. <x> To exit");
		System.out.println("Please choose an Option: ");

		Scanner s = new Scanner(System.in);

		String product = s.nextLine();

		if (!product.equalsIgnoreCase("X")) {
			GenericQueue<Product> productResults = ProductDB.getProducts(product);
			System.out.println("------Product listing-------");
			while (productResults.size() > 0) {

				System.out.println(productResults.dequeue().toString() + "\n");

			}
		} else {
			System.out.println("End of line...........");
		}

	}
}

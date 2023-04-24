

import java.util.List;
import java.util.Scanner;




public class TestComposerApp {

	public static void main(String[] args) {
		String isContinue = "y";
		MemoComposerDao dao = new MemoComposerDao();
		while (isContinue.equalsIgnoreCase("y")) {
		menu();
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Please choose an option:");
		int input = sc.nextInt();
		
		if (input == 1) {
			
			
			List<Composer> trans = dao.findAll();

			for (Composer composer : trans) {
				System.out.println(composer.toString());
				System.out.println("\n");
			}

		} else if (input == 2) {
			System.out.println("Please enter an ID");
			int id = sc.nextInt();
			Composer composer = dao.findBy(id);
			System.out.println("---DISPLAYING COMPOSER---");
			
			System.out.println(composer.toString());
		} else if (input == 3) {
			System.out.println("Enter an Id: " );
			int id = sc.nextInt();
			System.out.println("Enter a Name: " );
			String name = sc.next();
			System.out.println("Enter a Genre: ");
			String genre = sc.next();
			
			Composer composer = new Composer();
			composer.setId(id);
			composer.setName(name);
			composer.setGenre(genre);
			dao.insert(composer);
		}else if (input == 4) {
			isContinue = "n";
		}
		}
	}
	
	private static void menu() {
		System.out.println("MENU OPTIONS \n");
		System.out.println("  1.View Composers");
		System.out.println("  2.Find Composer");
		System.out.println("  3.Add Composer");
		System.out.println("  4.Exit");
		
	}
}

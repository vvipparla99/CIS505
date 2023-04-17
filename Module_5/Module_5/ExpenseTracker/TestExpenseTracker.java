
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TestExpenseTracker {

	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to the Expense Tracker \n");

		String isContinue = "y";
		while (isContinue.equalsIgnoreCase("y")) {
			
			menu();

			Scanner sc = new Scanner(System.in);

			int input = ValidatorIO.getInt(sc, "Please choose an option:");

			if (input == 1) {
				ArrayList<Transaction> trans = TransactionIO.findAll();

				for (Transaction expenses : trans) {
					System.out.println("Date: " + expenses.getDate());
					System.out.println("Description: " + expenses.getDescription());
					System.out.printf("Amount: $%,6.2f", expenses.getAmount());
					System.out.println("\n");
				}

			} else if (input == 2) {
				String c = "y";
				ArrayList<Transaction> transactions = new ArrayList<>();
				while (c.equalsIgnoreCase("y")) {

					String desc = ValidatorIO.getString(sc, "\n Enter the description:");
					double amount = ValidatorIO.getDouble(sc, "Enter Amount:");

					Transaction transaction = new Transaction(new SimpleDateFormat("MM-dd-yyyy").format(new Date()), desc, amount);
					transactions.add(transaction);
					c = ValidatorIO.getString(sc, "Add another transaction? (y/n):");
				}

				try {
					TransactionIO.bulkInsert(transactions);
				} catch (IOException e) {
					System.out.println("\n Exception: " + e.getMessage());
				}
			} else if (input == 3) {
				double monthlyExpenses = 0;
				ArrayList<Transaction> trans = TransactionIO.findAll();
				for (Transaction expenses : trans) {
					monthlyExpenses += expenses.getAmount();

				}
				System.out.printf("Your total monthly expense is: $%,6.2f", monthlyExpenses);
				System.out.println("\n");
			}

			isContinue = ValidatorIO.getString(sc, "Continue? (y/n):");

		}

		System.out.println("Program terminated by the user....");

	}

	private static void menu() {
		System.out.println("MENU OPTIONS \n");
		System.out.println("  1.View Tranactions");
		System.out.println("  2.Add Transactions");
		System.out.println("  3.View Expense");
		
	}
}

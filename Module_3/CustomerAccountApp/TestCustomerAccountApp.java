

import java.util.Scanner;

/**
 * 
 * @author Venkat
 *
 */
public class TestCustomerAccountApp {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Customer Account App");
		System.out.println("Enter a Customer ID:");
		System.out.println("ex: 1007,1008,1009>: ");
		
		Scanner s = new Scanner(System.in);
		
		String id = s.nextLine();
		
		Customer customer = CustomerDB.getCustomer(id);
		String isContinue = "y";
		Account act = new Account();
		while(isContinue.equalsIgnoreCase("y")) {
		
		act.displayMenu();
		
		String operation = s.nextLine();
		
		if(operation.equalsIgnoreCase("b")) {
			System.out.printf("Account Balance: $%,6.2f",act.getBalance());
			System.out.println("Continue? (y/n):");
			isContinue = s.nextLine();
			
		}else if(operation.equalsIgnoreCase("d")) {
			System.out.println("Enter Deposit Amount:");
			double input = s.nextDouble();
			s.nextLine();
			act.deposit(input);
			System.out.println("Continue? (y/n):");
			isContinue = s.nextLine();
			
		}else if(operation.equalsIgnoreCase("w")) {
			System.out.println("Enter Withdraw Amount:");
			double input = s.nextDouble();
			s.nextLine();
			act.withdraw(input);
			System.out.println("Continue? (y/n):");
			String in = s.nextLine();
			isContinue = in;
			
		}else {
			System.out.println("Error: Invalid option");
			System.out.println("Continue? (y/n):");
			isContinue = s.nextLine();
		}
		}
		s.close();
		System.out.println("-----Customer Details-----");
		System.out.println(customer.toString());
		System.out.printf("Balance as of "+act.getTransactionDate()+" is $%,6.2f",act.getBalance());
	}

}

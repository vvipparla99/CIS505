

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  
 * 
 * 
 * @author Venkat
 *
 */
public class Account {

	private double balance=200;

	
	public double getBalance() {
		return balance;
	}

	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amt) {
		balance = amt + getBalance();
	}
	
	public void withdraw(double amt) {
		
		if(getBalance() >= amt)
		balance = getBalance() - amt ;
		System.out.println(balance);
	}
	
	public void displayMenu() {
		
		System.out.println("Account Menu");
		System.out.println("Enter <D/d> for deposit");
		System.out.println("Enter <W/w> for deposit");
		System.out.println("Enter <B/b> for deposit");
		System.out.println("Enter Option>: ");
	}
	
	public String getTransactionDate() {
		Format f = new SimpleDateFormat("MM-dd-yyyy");
		return f.format(new Date());
	}
}

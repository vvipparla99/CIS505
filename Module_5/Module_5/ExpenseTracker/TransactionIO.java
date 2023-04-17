
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionIO {
	
	private static String FILE_NAME="expenses.txt";
	
	private static File file = new File(FILE_NAME);
	
	public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException{
		
		PrintWriter output = null;
		
		if(file.exists()) {
			output = new PrintWriter(new FileOutputStream(file,true));
		}else {
			output= new PrintWriter(FILE_NAME);
		}
		
		for(Transaction tran : transactions) {
			output.print("\n"+tran.getDate()+" ");
			output.print(tran.getDescription()+" ");
			output.print(tran.getAmount()+" ");
		}
		output.close();
	}
	
	public static ArrayList<Transaction> findAll() throws IOException{
		
		ArrayList<Transaction> transactions = new ArrayList<>();
		
		Scanner input = new Scanner(file).useDelimiter("\n");
		while(input.hasNext()) {
			String[] expense = input.next().split(" ");
			Transaction transaction = new Transaction();
			transaction.setDate(expense[0]);
			transaction.setDescription(expense[1]);
			transaction.setAmount(Double.parseDouble(expense[2]));
			transactions.add(transaction);
		}
		
		return transactions;
	}
}

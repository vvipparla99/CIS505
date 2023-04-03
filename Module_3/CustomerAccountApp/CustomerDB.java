package com.java8;

/**
 * 
 * @author Venkat
 *
 */
public class CustomerDB {

	private static String id1 = "1007";
	private static String id2 = "1008";
	private static String id3 = "1009";
	
	
	public static Customer getCustomer(String id) {
		if(id.equals(id1)) {
			
			return new Customer("Venkat","10503 bedford","Omaha","68136");
		}else if(id.equals(id2)) {
			
			return new Customer("Nag","2713 S 24th Ave","Omaha","68137");
		}else if(id.equals(id3)) {
			
			return new Customer("Chaithu","211 I Street","Omaha","68135");
		}else {
			return new Customer("Navya","311 K Street","Omaha","68134");
		}
		
	}
}

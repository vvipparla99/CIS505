
public class FinanceCalculator {

	private static int MONTHS_IN_YEAR=12;
	
	static double calculateFutureValue(double monthlyPayment, double rate, int years) {
		
		int months = MONTHS_IN_YEAR*years;
		
		double interestRate = (1+rate/100);
		
		double presentValue  = monthlyPayment * months;
		
		return presentValue*(Math.pow(interestRate, months));
	}
}

package taxcalculator;

import taxcalculator.contracts.CivilContract;
import taxcalculator.contracts.Contract;
import taxcalculator.contracts.EmploymentContract;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TaxCalculator {

	public static void main(String[] args) {
		double income;
		char contractType;
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			System.out.print("Enter income: ");
			income = Double.parseDouble(br.readLine());

			System.out.print("Contract Type: (E)mployment, (C)ivil: ");
			contractType = br.readLine().charAt(0);

		} 
		catch (Exception ex) {
			System.out.println("Incorrect");
			System.err.println(ex.getMessage());
			return;
		}

		Contract contract = null;

		if (contractType == 'E') {
			contract = new EmploymentContract(income);
		} else if (contractType == 'C') {
			contract = new CivilContract(income);
		}

		if (contract != null) {
			contract.calculateTaxes();
		} else {
			System.out.println("Unknown type of contract!");
		}
	}
}

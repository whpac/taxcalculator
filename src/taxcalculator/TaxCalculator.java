package taxcalculator;

import taxcalculator.contracts.Contract;
import taxcalculator.input.ContractInput;
import taxcalculator.output.TaxReportOutput;

public class TaxCalculator {

	public static void main(String[] args) {
		Contract contract;
		ContractInput contractInput = null;
		TaxReportOutput reportOutput = null;
		try {
			/* TODO: Move to a class implementing ContractInput
			double income;
			char contractType;

			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			System.out.print("Enter income: ");
			income = Double.parseDouble(br.readLine());

			System.out.print("Contract Type: (E)mployment, (C)ivil: ");
			contractType = br.readLine().charAt(0);

			if (contractType == 'E') {
				contract = new EmploymentContract(income);
			} else if (contractType == 'C') {
				contract = new CivilContract(income);
			}
			*/
			contract = contractInput.getContract();
		} 
		catch (Exception ex) {
			System.err.println(ex.getMessage());
			return;
		}

		TaxReport report = contract.calculateTaxes();

		reportOutput.putTaxReport(report);
	}
}

package taxcalculator;

import taxcalculator.contracts.Contract;
import taxcalculator.input.ConsoleContractInput;
import taxcalculator.input.ContractInput;
import taxcalculator.output.ConsoleTaxReportOutput;
import taxcalculator.output.TaxReportOutput;

public class TaxCalculator {

	public static void main(String[] args) {
		Contract contract;
		ContractInput contractInput = new ConsoleContractInput();
		TaxReportOutput reportOutput = new ConsoleTaxReportOutput();
		try {
			contract = contractInput.getContract();
			if (contract == null) {
				System.err.println("No contract provided");
				return;
			}
		} 
		catch (Exception ex) {
			System.err.println(ex.getMessage());
			return;
		}

		TaxReport report = contract.calculateTaxes();

		reportOutput.putTaxReport(report);
	}
}

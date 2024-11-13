package taxcalculator.output;

import taxcalculator.TaxReport;
import taxcalculator.taxes.Tax;

public class ConsoleTaxReportOutput implements TaxReportOutput {

    @Override
    public void putTaxReport(TaxReport taxReport) {
        if (taxReport == null) {
            throw new IllegalArgumentException("No report provided");
        }

        System.out.println("=== Tax Report ===");
        System.out.println("Gross Income: " + taxReport.getGrossIncome());
        System.out.println("Net Income: " + taxReport.getNetIncome());
        System.out.println("Taxes Applied:");
        for (Tax tax : taxReport.getTaxes()) {
            System.out.println(tax.getName() + ": " + tax.getTaxAmount() + " (Base: " + tax.getTaxBase() + ")");
        }
        System.out.println("=== End of Report ===");
    }
}

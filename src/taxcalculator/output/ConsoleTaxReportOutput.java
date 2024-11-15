package taxcalculator.output;

import taxcalculator.TaxReport;
import taxcalculator.taxes.Tax;
import java.text.DecimalFormat;

public class ConsoleTaxReportOutput implements TaxReportOutput {

    @Override
    public void putTaxReport(TaxReport taxReport) {
        if (taxReport == null) {
            throw new IllegalArgumentException("No report provided");
        }

        DecimalFormat df = new DecimalFormat("#0.00");

        System.out.println("=== Tax Report ===");
        System.out.println("Gross Income: " + df.format(taxReport.getGrossIncome()));
        System.out.println("Net Income: " + df.format(taxReport.getNetIncome()));
        System.out.println("Taxes Applied:");
        for (Tax tax : taxReport.getTaxes()) {
            System.out.println(tax.getName() + ": " + df.format(tax.getTaxAmount()) + " (Base: " + df.format(tax.getTaxBase()) + ")");
        }
        System.out.println("=== End of Report ===");
    }
}

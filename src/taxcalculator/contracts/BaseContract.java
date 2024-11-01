package taxcalculator.contracts;

import java.text.DecimalFormat;

public abstract class BaseContract {
    // Constants for social security and tax rates
    private static final double SOCIAL_SECURITY_RATE = 9.76;
    private static final double HEALTH_SECURITY_RATE = 1.5;
    private static final double SICKNESS_SECURITY_RATE = 2.45;
    private static final double HEALTH_TAX_RATE_1 = 9.0;
    private static final double HEALTH_TAX_RATE_2 = 7.75;
    protected static final double TAX_FREE_INCOME = 46.33;
    private static final double TAX_RATE = 18.0;

    protected double calculatePercentage(double amount, double rate) {
        return (amount * rate) / 100;
    }

    protected double calculateTax(double income) {
        return (income * TAX_RATE) / 100;
    }

    protected double calculateNetIncome(double income) {
        double socialSecurityTax = calculatePercentage(income, SOCIAL_SECURITY_RATE);
        double healthSecurityTax = calculatePercentage(income, HEALTH_SECURITY_RATE);
        double sicknessSecurityTax = calculatePercentage(income, SICKNESS_SECURITY_RATE);
        return income - (socialSecurityTax + healthSecurityTax + sicknessSecurityTax);
    }

    protected double[] calculateHealthTaxes(double netIncome) {
        double healthTax1 = calculatePercentage(netIncome, HEALTH_TAX_RATE_1);
        double healthTax2 = calculatePercentage(netIncome, HEALTH_TAX_RATE_2);
        return new double[]{healthTax1, healthTax2};
    }

    protected double calculateAdvanceTax(double taxableIncome) {
        return calculateTax(taxableIncome) - TAX_FREE_INCOME;
    }

    protected void displayResult(String label, double value) {
        System.out.println(label + ": " + new DecimalFormat("#.00").format(value));
    }

    protected void displayResult(String label, String value) {
        System.out.println(label + ": " + value);
    }

    protected void displayResult(String label, double value, double roundedValue) {
        System.out.println(label + ": " + new DecimalFormat("#.00").format(value) + " (Rounded: " + roundedValue + ")");
    }
}

package taxcalculator.contracts;

import java.text.DecimalFormat;

public abstract class BaseContract {
    // Constants for social security and tax rates
    private final double SOCIAL_SECURITY_RATE = 9.76;
    private final double HEALTH_SECURITY_RATE = 1.5;
    private final double SICKNESS_SECURITY_RATE = 2.45;
    private final double HEALTH_TAX_RATE_1 = 9.0;
    private final double HEALTH_TAX_RATE_2 = 7.75;
    protected double TAX_FREE_INCOME = 46.33;
    private final double TAX_RATE = 18.0;

    public void calculateTaxes(double income) {
        displayResult("Income", income);

        double netIncome = calculateNetIncome(income);
        double taxDeductibleExpenses = calculateDeducibleExpenses(netIncome);
        displayResult("Original net income", netIncome);
        displayResult("Tax deducible expenses", taxDeductibleExpenses);

        double[] healthTaxes = calculateHealthTaxes(netIncome);
        double healthTax1 = healthTaxes[0];
        double healthTax2 = healthTaxes[1];

        displayResult("Health Tax (9%)", healthTax1);
        displayResult("Health Tax (7.75%)", healthTax2);

        double taxableIncome = netIncome - taxDeductibleExpenses;
        double roundedTaxableIncome = Math.round(taxableIncome);
        displayResult("Taxable income", taxableIncome, roundedTaxableIncome);

        double advanceTax = calculateAdvanceTax(roundedTaxableIncome, healthTax2);
        displayResult("Advance tax 18% (reduced, paid)", advanceTax);

        double finalNetIncome = netIncome - (healthTax1 + Math.round(advanceTax));
        displayResult("Final net income", finalNetIncome);
    }

    protected double calculatePercentage(double amount, double rate) {
        return (amount * rate) / 100;
    }

    protected double calculateTax(double income) {
        return (income * TAX_RATE) / 100;
    }

    protected abstract double calculateDeducibleExpenses(double netIncome);

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

    protected double calculateAdvanceTax(double taxableIncome, double healthTax2) {
        return calculateTax(taxableIncome) - TAX_FREE_INCOME - healthTax2;
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

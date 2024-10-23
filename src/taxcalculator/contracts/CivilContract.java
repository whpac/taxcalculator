package taxcalculator.contracts;

import java.text.DecimalFormat;

public class CivilContract extends BaseContract implements Contract {
    private final double income;

    public CivilContract(double income) {
        this.income = income;
    }

    public void calculateTaxes() {
        DecimalFormat df00 = new DecimalFormat("#.00");
        DecimalFormat df = new DecimalFormat("#");

        System.out.println("income " + income);
        double d_income = calculateIncome(income);
        System.out.println("Social security tax = " + df00.format(soc_security));
        System.out.println("Health social security tax = " + df00.format(soc_health_security));
        System.out.println("Sickness social security tax = " + df00.format(soc_sick_security));

        System.out.println("Income for calculating health security tax: " + d_income);
        calculateOtherTaxes(d_income);
        System.out.println("Health security tax: 9% = " + df00.format(soc_health1) + " 7,75% = " + df00.format(soc_health2));
        taxFreeIncome = 0;
        taxDeductibleExpenses = (income * 20) / 100;
        System.out.println("Tax deductible expenses = " + taxDeductibleExpenses);

        double taxedIncome = d_income - taxDeductibleExpenses;
        double taxedIncome0 = Double.parseDouble(df.format(taxedIncome));
        System.out.println("income to be taxed = " + taxedIncome + " rounded = " + df.format(taxedIncome0));
        advanceTax = calculateTax(taxedIncome0);
        System.out.println("Advance tax 18 % = " + advanceTax);
        // System.out.println("Already paid tax = " + df00.format(taxPaid));
        double advanceTaxPaid = calculateAdvanceTax();
        double advanceTaxPaid0 = Double.parseDouble(df.format(advanceTaxPaid));
        System.out.println("Advance tax  = " + df00.format(advanceTaxPaid) + " rounded = " + df.format(advanceTaxPaid0));
        double netIncome = income - ((soc_security + soc_health_security + soc_sick_security) + soc_health1 + advanceTaxPaid0);
        System.out.println();
        System.out.println("Net income = " + df00.format(netIncome));
    }
}

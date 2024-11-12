package taxcalculator.contracts;

import taxcalculator.TaxReport;

public class CivilContract extends BaseContract implements Contract {
    private final double income;
    private final double DEDUCIBLE_EXPENSES_RATE = 20.0;

    public CivilContract(double income) {
        this.income = income;
        this.TAX_FREE_INCOME = 0.0;
    }

    @Override
    protected double calculateDeducibleExpenses(double netIncome) {
        return calculatePercentage(netIncome, DEDUCIBLE_EXPENSES_RATE);
    }

    @Override
    public TaxReport calculateTaxes() {
        displayResult("Contract Type", "Civil");
        return calculateTaxes(income);
    }
}

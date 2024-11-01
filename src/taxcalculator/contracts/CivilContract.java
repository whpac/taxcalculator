package taxcalculator.contracts;

public class CivilContract extends BaseContract implements Contract {
    private final double income;
    private static final double EXPENSES_RATE = 20.0;

    public CivilContract(double income) {
        this.income = income;
    }

    @Override
    public void calculateTaxes() {
        displayResult("Income", income);

        double taxDeductibleExpenses = calculatePercentage(income, EXPENSES_RATE);
        double netIncome = calculateNetIncome(income);

        double[] healthTaxes = calculateHealthTaxes(netIncome);
        double healthTax1 = healthTaxes[0];
        double healthTax2 = healthTaxes[1];

        displayResult("Health Tax (9%)", healthTax1);
        displayResult("Health Tax (7.75%)", healthTax2);

        double taxableIncome = netIncome - taxDeductibleExpenses;
        double roundedTaxableIncome = Math.round(taxableIncome);
        displayResult("Taxable income", taxableIncome, roundedTaxableIncome);

        double advanceTax = calculateAdvanceTax(roundedTaxableIncome);
        displayResult("Advance tax 18%", advanceTax);

        double finalNetIncome = income - (healthTax1 + healthTax2 + advanceTax);
        displayResult("Final net income", finalNetIncome);
    }
}

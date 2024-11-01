package taxcalculator.contracts;

public class EmploymentContract extends BaseContract implements Contract {
    private final double income;
    private static final double FIXED_EXPENSES = 111.25;

    public EmploymentContract(double income) {
        this.income = income;
    }

    @Override
    public void calculateTaxes() {
        displayResult("Contract Type", "Employment");
        displayResult("Income", income);

        double netIncome = calculateNetIncome(income);

        double[] healthTaxes = calculateHealthTaxes(netIncome);
        double healthTax1 = healthTaxes[0];
        double healthTax2 = healthTaxes[1];

        displayResult("Health Tax (9%)", healthTax1);
        displayResult("Health Tax (7.75%)", healthTax2);

        double taxableIncome = netIncome - FIXED_EXPENSES;
        double roundedTaxableIncome = Math.round(taxableIncome);
        displayResult("Taxable income", taxableIncome, roundedTaxableIncome);

        double advanceTax = calculateAdvanceTax(roundedTaxableIncome);
        displayResult("Advance tax 18%", advanceTax);

        double finalNetIncome = income - (healthTax1 + healthTax2 + advanceTax);
        displayResult("Final net income", finalNetIncome);
    }
}

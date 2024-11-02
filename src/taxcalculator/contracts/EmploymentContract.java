package taxcalculator.contracts;

public class EmploymentContract extends BaseContract implements Contract {
    private final double income;
    private final double FIXED_DEDUCIBLE_EXPENSES = 111.25;

    public EmploymentContract(double income) {
        this.income = income;
    }

    @Override
    protected double calculateDeducibleExpenses(double netIncome) {
        return FIXED_DEDUCIBLE_EXPENSES;
    }

    @Override
    public void calculateTaxes() {
        displayResult("Contract Type", "Employment");
        calculateTaxes(income);
    }
}

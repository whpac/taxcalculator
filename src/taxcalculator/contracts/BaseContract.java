package taxcalculator.contracts;

public abstract class BaseContract {
    // social security taxes
    public double soc_security = 0; // 9,76% of basis
    public double soc_health_security = 0; // 1,5% of basis
    public double soc_sick_security = 0; // 2,45% of basis
    // health-related taxes
    public double soc_health1 = 0; // of basis up to 9%
    public double soc_health2 = 0; // of basis up to  7,75 %
    public double taxFreeIncome = 46.33; // tax-free income monthly 46,33 PLN
    public double advanceTax = 0;

    protected double calculateAdvanceTax() {
        return advanceTax - soc_health2 - taxFreeIncome;
    }

    protected double calculateTax(double income) {
        return (income * 18) / 100;
    }

    protected double calculateIncome(double income) {
        soc_security = (income * 9.76) / 100;
        soc_health_security = (income * 1.5) / 100;
        soc_sick_security = (income * 2.45) / 100;
        return (income - soc_security - soc_health_security - soc_sick_security);
    }

    protected void calculateOtherTaxes(double income) {
        soc_health1 = (income * 9) / 100;
        soc_health2 = (income * 7.75) / 100;
    }
}

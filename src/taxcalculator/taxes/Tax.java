package taxcalculator.taxes;

public class Tax {
    private final String name;
    private final double amount;
    private final double base;

    public Tax(String name, double amount, double base) {
        this.name = name;
        this.amount = amount;
        this.base = base;
    }

    public String getName() {
        return name;
    }

    public double getTaxAmount() {
        return amount;
    }

    public double getTaxBase() {
        return base;
    }
}

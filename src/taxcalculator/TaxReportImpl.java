package taxcalculator;

import java.util.List;

import taxcalculator.taxes.Tax;

public class TaxReportImpl implements TaxReport {

    private double grossIncome;
    private double netIncome;
    private List<Tax> taxes;

    public TaxReportImpl(double grossIncome, double netIncome, List<Tax> taxes) {
        this.grossIncome = grossIncome;
        this.netIncome = netIncome;
        this.taxes = taxes;
    }

    @Override
    public double getGrossIncome() {
        return grossIncome;
    }

    @Override
    public double getNetIncome() {
        return netIncome;
    }

    @Override
    public List<Tax> getTaxes() {
        return taxes;
    }
    
}

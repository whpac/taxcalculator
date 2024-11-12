package taxcalculator;

import taxcalculator.taxes.Tax;

import java.util.List;

public interface TaxReport {

    double getGrossIncome();

    double getNetIncome();

    /**
     * Returns a list of all the taxes that were applied to this contract
     */
    List<Tax> getTaxes();
}

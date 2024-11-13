package taxcalculator.input;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import taxcalculator.contracts.CivilContract;
import taxcalculator.contracts.Contract;
import taxcalculator.contracts.EmploymentContract;

public class ConsoleContractInput implements ContractInput {

    @Override
    public Contract getContract() {
        try{
            double income;
            char contractType;

            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            System.out.print("Enter income: ");
            income = Double.parseDouble(br.readLine());

            System.out.print("Contract Type: (E)mployment, (C)ivil: ");
            contractType = br.readLine().charAt(0);

            if (contractType == 'E') {
                return new EmploymentContract(income);
            } else if (contractType == 'C') {
                return new CivilContract(income);
            } else {
                throw new IllegalArgumentException("Invalid contract type");
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error reading contract data", ex);
        }
    }
    
}

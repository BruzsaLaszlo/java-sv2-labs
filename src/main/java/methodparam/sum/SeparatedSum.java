package methodparam.sum;

public class SeparatedSum {


    public Sums sum(String floatingNumbers) {

        floatingNumbers = floatingNumbers.replace(',', '.');

        Sums sums = new Sums();

        for (String s : floatingNumbers.split(";")) {

            double number = Double.parseDouble(s);

            if (number > 0)
                sums.addPositive(number);
            else
                sums.addNegative(number);

        }

        return sums;

    }

}

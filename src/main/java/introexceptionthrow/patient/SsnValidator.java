package introexceptionthrow.patient;

public class SsnValidator {

    public boolean isValidSsn(String ssn) {

        ssn = ssn.replace(" ", "");

        if (ssn.length() != 9)
            return false;

        try {

            int sumOdd = 0;
            int sumEven = 0;
            for (int i = 0; i < 8; i++) {
                var num = Integer.parseInt(ssn.substring(i, i + 1));
                if (i % 2 == 0)
                    sumOdd += 3 * num;
                else
                    sumEven += 7 * num;
            }

            return (sumEven + sumOdd) % 10 == Integer.parseInt(ssn.substring(8, 9));

        } catch (NumberFormatException exception) {
            return false;
        }

    }
}

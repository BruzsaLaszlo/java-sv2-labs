package defaultconstructor.date;

public class SimpleDateFormatter {

    private final CountryCode defaultCountryCode;

    public SimpleDateFormatter() {
        defaultCountryCode = CountryCode.HU;
    }

    public String formatDateString(SimpleDate simpleDate) {
        return simpleDate.getYear()
                + "-"
                + simpleDate.getMonth()
                + "-"
                + simpleDate.getDay();
    }

    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate) {

        switch (countryCode) {

            case HU :
                return formatDateString(simpleDate);

            case EN:
                return simpleDate.getDay()
                        + "-"
                        + simpleDate.getMonth()
                        + "-"
                        + simpleDate.getYear();

            case US:
                return simpleDate.getMonth()
                        + "-"
                        + simpleDate.getDay()
                        + "-"
                        + simpleDate.getYear();

            default: throw new IllegalStateException();
        }
    }

}

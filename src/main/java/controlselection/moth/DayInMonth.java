package controlselection.moth;

public class DayInMonth {

    public int getDayInMonth(int year, String month) {

        int m;

        switch (month.toLowerCase()) {

            case    "február":
                                m = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 29 : 28;
                                break;
            case    "január",
                    "március",
                    "május",
                    "július",
                    "augusztus",
                    "október",
                    "december":
                                m = 31;
                                break;
            case    "április",
                    "június",
                    "szeptember",
                    "november":
                                m = 30;
                                break;
            default:            m = 0;

        }

        return m;

    }

}

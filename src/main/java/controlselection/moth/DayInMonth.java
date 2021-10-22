package controlselection.moth;

public class DayInMonth {

    public int getDayInMonth(int year, String  month) {

        int m;

        switch (month.toLowerCase()) {
            case "január": m = 31; break;
            case "február": m = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 29 : 28; break;
            case "március": m = 31; break;
            case "április": m = 30; break;
            case "május": m = 31; break;
            case "június": m = 30; break;
            case "július": m = 31; break;
            case "augusztus": m = 31; break;
            case "szeptember": m = 30; break;
            case "október": m = 31; break;
            case "november": m = 30; break;
            case "december": m = 31; break;
            default: return 0;
        }

        return m;

    }

}

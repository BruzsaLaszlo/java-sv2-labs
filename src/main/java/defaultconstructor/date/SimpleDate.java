package defaultconstructor.date;

public class SimpleDate {

    private int year;
    private int month;
    private int day;

    public void setDate(int year, int month, int day) {
        isCorrect(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private boolean isCorrect(int year, int month, int day) {

        if (year < 1900)
            throw new IllegalArgumentException("invalid year: " + year);

        if (day != calculateMonthLength(year, month))
            throw new IllegalArgumentException("invalid day: " + day);

        return true;
    }

    private boolean isLeapYear(int year) {

        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;

    }

    private int calculateMonthLength(int year, int month) {

        switch (month) {

            case 1, 3, 5, 7, 8, 10, 12:
                return 31;

            case 4, 6, 9, 11:
                return 30;

            case 2:
                if (isLeapYear(year))
                    return 29;
                else return 28;

            default:
                throw new IllegalArgumentException("invalid month: " + month);
        }
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}

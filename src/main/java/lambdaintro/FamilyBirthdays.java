package lambdaintro;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;

public class FamilyBirthdays {

    private LocalDate[] birthDays;

    public FamilyBirthdays(LocalDate... birthDays) {
        this.birthDays = birthDays;
    }

    public boolean isFamilyBirthday(TemporalAccessor date) {
        return Arrays.stream(birthDays)
                .anyMatch(birthDay -> compareLocalDates(birthDay, LocalDate.from(date)) == 0);
    }

    public long nextFamilyBirthDay(TemporalAccessor ta) {
        LocalDate from = LocalDate.from(ta);

        var found = Arrays.stream(birthDays)
                .filter(birthDay -> compareLocalDates(birthDay, from) >= 0)
                .min(this::compareLocalDates)
                .orElseGet(() -> Arrays.stream(birthDays)
                        .min(this::compareLocalDates)
                        .orElseThrow(IllegalStateException::new))
                .withYear(from.getYear());

        if (found.isBefore(from)) {
            return from.until(found.plusYears(1), ChronoUnit.DAYS);
        }
        return from.until(found, ChronoUnit.DAYS);
    }

    private int compareLocalDates(LocalDate date, LocalDate other) {
        return date.withYear(LocalDate.now().getYear()).getDayOfYear() -
                other.withYear(LocalDate.now().getYear()).getDayOfYear();
    }

}

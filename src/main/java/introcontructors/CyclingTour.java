package introcontructors;

import java.time.LocalDate;

public class CyclingTour {

    private String  description;
    private LocalDate startTime;
    private int numberOfPeaple;
    private double kms;

    public static void main(String[] args) {

        CyclingTour cyclingTour = new CyclingTour("TourDeFrance", LocalDate.of(2022, 6, 17));        System.out.println(cyclingTour);

        cyclingTour.registerPerson(50);
        cyclingTour.ride(2345);
        System.out.println(cyclingTour);

    }

    public CyclingTour(String description, LocalDate startTime) {
        this.description = description;
        this.startTime = startTime;
    }

    public void registerPerson(int person) {
        numberOfPeaple += person;
    }

    public void ride(int kms) {
        this.kms += kms;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public int getNumberOfPeaple() {
        return numberOfPeaple;
    }

    public double getKms() {
        return kms;
    }

    @Override
    public String toString() {
        return "CyclingTour{" +
                "description='" + description + '\'' +
                ", startTime=" + startTime +
                ", numberOfPeaple=" + numberOfPeaple +
                ", kms=" + kms +
                '}';
    }
}

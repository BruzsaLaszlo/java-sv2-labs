package inheritanceconstructor.classroom;

public class Course {

    private int participants;
    private Facility facilityNeeded;

    public Course(int participant, Facility facilityNeeded) {
        this.participants = participant;
        this.facilityNeeded = facilityNeeded;
    }

    public int getParticipants() {
        return participants;
    }

    public Facility getFacilityNeeded() {
        return facilityNeeded;
    }
}

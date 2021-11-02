package projects.meetingrooms;

import java.util.ArrayList;
import java.util.List;

public class Office {

    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public boolean addMeetigRoom(MeetingRoom meetingRoom) {
        return meetingRooms.add(meetingRoom);
    }

    public void printNames() {
        for (MeetingRoom mr : meetingRooms)
            System.out.println(mr.getName());
    }

    public void printNamesReverse() {
        for (int i = meetingRooms.size() - 1; i >= 0; i--)
            System.out.println(meetingRooms.get(i).getName());
    }

    public void printEvenNames() {
        for (int i = 1; i < meetingRooms.size(); i += 2)
            System.out.println(meetingRooms.get(i).getName());
    }

    public void printAreas() {
        for (MeetingRoom mr : meetingRooms)
            System.out.println(mr);
    }

    public void printMeetingRoomsWithName(String name) {
        for (MeetingRoom mr : meetingRooms)
            if (mr.getName().equals(name)) {
                System.out.println(mr);
                break;
            }
    }

    public void printMeetingRoomsContains(String part) {
        for (MeetingRoom mr : meetingRooms)
            if (mr.getName().toLowerCase().contains(part.toLowerCase())) {
                System.out.println(mr);
                break;
            }
    }

    public void printAreasLargerThan(int area) {
        for (MeetingRoom mr : meetingRooms)
            if (mr.getArea() > area)
                System.out.println(mr);
    }
}

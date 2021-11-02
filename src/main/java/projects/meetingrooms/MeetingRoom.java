package projects.meetingrooms;

public class MeetingRoom {

    private String name;
    private int length;
    private int width;

    public MeetingRoom(String name, int width, int length) {
        this.name = name;
        this.length = length;
        this.width = width;
    }

    @Override
    public String toString() {
        return String.format("%s [%dm x %dm] %dm2", name, width, length, getArea());
    }

    public int getArea() {
        return length * width;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}

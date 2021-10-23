package introcontructors;

import java.time.LocalDateTime;

public class Task {

    private String title;
    private String description;
    private LocalDateTime startDateTime;
    private int duration;

    public static void main(String[] args) {

        Task task = new Task("porszívózás", "kisszobába szőnyeg");
        task.setDuration(2);
        task.start();

    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void start() {
        startDateTime = LocalDateTime.now();
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public int getDuration() {
        return duration;
    }
}

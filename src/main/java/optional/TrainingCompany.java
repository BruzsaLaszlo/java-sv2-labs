package optional;

import java.util.Comparator;
import java.util.List;

public class TrainingCompany {

    private List<Course> courses;

    public TrainingCompany(List<Course> courses) {
        this.courses = courses;
    }


    public Course getCheaperCourse(int maxPrice) {
        return courses.stream()
                .filter(course -> course.getPrice() < maxPrice)
                .min(Comparator.comparingInt(Course::getPrice))
                .orElseThrow(() -> new IllegalArgumentException("No such course."));
    }


    public int getPriceOfCourseWithGivenNameAndLevel(String name, Level level) {
        return courses.stream()
                .filter(course -> course.getName().equals(name) && course.getLevel() == level)
                .findFirst()
                .map(Course::getPrice)
                .orElseThrow(() -> new IllegalArgumentException("No such course."));
    }


    public String getNameOfCourseWithGivenLevel(Level level) {
        return courses.stream()
                .filter(course -> course.getLevel() == level)
                .findAny()
                .map(Course::getName)
                .orElse("Sorry, there is no course at this level.");
    }
}

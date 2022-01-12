package collectionsiterator;

import java.time.LocalDateTime;
import java.util.*;

public class HomeSchooling {

    private Set<OnlineLesson> onlineLessons = new TreeSet<>(Comparator.comparing(OnlineLesson::startTime));

    public void addNewLesson(OnlineLesson lesson) {
        onlineLessons.add(lesson);
    }

    public List<OnlineLesson> getLessonsByTitle(String title) {
        var result = new ArrayList<OnlineLesson>();
        Iterator<OnlineLesson> iterator = onlineLessons.iterator();
        while (iterator.hasNext()) {
            OnlineLesson ol = iterator.next();
            if (ol.lessonTitle().equals(title)) {
                result.add(ol);
            }
        }
        return result;
    }

    public void removeLesson(LocalDateTime startTime) {
        var iterator = onlineLessons.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().startTime().equals(startTime)) {
                iterator.remove();
            }
        }
    }

    public List<OnlineLesson> getLessons() {
        return List.copyOf(onlineLessons);
    }
}

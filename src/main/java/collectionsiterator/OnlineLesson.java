package collectionsiterator;

import java.time.LocalDateTime;

public record OnlineLesson(
        String teacherName,
        String lessonTitle,
        LocalDateTime startTime) {
}

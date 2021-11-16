package methodvarargs.gps;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HikinTour {

    private List<FieldPoint> fieldPoints = new ArrayList<>();

    public void logFieldPoints(LocalDateTime timeOfLogging, FieldPoint... fieldPointsToLog) {

        if (timeOfLogging == null)
            throw new IllegalArgumentException("invalid timeOfLogging parameter");

        for (FieldPoint fp : fieldPointsToLog) {
            fp.setTimeOfLogging(timeOfLogging);
            fieldPoints.add(fp);
        }

    }

}

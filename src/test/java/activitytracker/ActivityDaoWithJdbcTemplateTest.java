package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;

import static activitytracker.SportType.*;
import static java.time.LocalDateTime.now;
import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoWithJdbcTemplateTest {

    ActivityDaoWithJdbcTemplate activityDao;

    Activity biking = new Activity(now().withNano(0),
            "Cycling, also called bicycling or biking, is the use of bicycles for transport, recreation, exercise or sport.",
            BIKING);
    Activity basketball = new Activity(now().minusDays(1),
            "Basketball is a game played between two teams of five players each on a rectangular court, usually indoors.",
            BASKETBALL);
    Activity running = new Activity(now().minusDays(2),
            "Running is a complex, coordinated process which involves the entire body.",
            RUNNING);
    Activity hiking = new Activity(now().plusDays(1),
            "A long, vigorous walk, usually on trails or footpaths in the countryside.",
            HIKING);

    List<TrackPoint> szepenSorban = List.of(
            new TrackPoint(now().withNano(0).minusDays(12), 12.323232, 43.324234),
            new TrackPoint(now().withNano(0).minusDays(11), 13.323232, 44.324234),
            new TrackPoint(now().withNano(0).minusDays(10), 14.323232, 45.324234),
            new TrackPoint(now().withNano(0).minusDays(9), 16.323232, 46.324234),
            new TrackPoint(now().withNano(0).minusDays(8), 17.323232, 47.324234),
            new TrackPoint(now().withNano(0).minusDays(7), 18.323232, 48.324234));

    @BeforeEach
    void setUp() throws SQLException {

        MariaDbDataSource mariaDbDataSource = new MariaDbDataSource();
        mariaDbDataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
        mariaDbDataSource.setUser("activitytracker");
        mariaDbDataSource.setPassword("activitytracker");

        Flyway flyway = Flyway.configure()
                .dataSource(mariaDbDataSource)
                .locations("filesystem:src/test/resources/activitytracker")
                .load();

        flyway.clean();
        flyway.migrate();

        activityDao = new ActivityDaoWithJdbcTemplate(mariaDbDataSource);

    }

    @Test
    void saveActivity() {

        activityDao.saveActivity(biking);
        activityDao.saveActivity(basketball);
        activityDao.saveActivity(running);

        var actual = activityDao.listActivities();

        assertSame(BIKING, actual.get(0).getType());
        assertSame(BASKETBALL, actual.get(1).getType());
        assertSame(RUNNING, actual.get(2).getType());

        Activity sameWithId = activityDao.saveActivity(hiking);
        assertSame(HIKING, sameWithId.getType());
        assertEquals(4, sameWithId.getId());

    }

    @Test
    void listActivities() {

        activityDao.saveActivity(biking);
        activityDao.saveActivity(basketball);
        activityDao.saveActivity(running);
        activityDao.saveActivity(hiking);

        var actual = activityDao.listActivities();

        assertEquals(4, actual.size());
        assertSame(BIKING, actual.get(0).getType());
        assertSame(BASKETBALL, actual.get(1).getType());
        assertSame(RUNNING, actual.get(2).getType());
        assertSame(HIKING, actual.get(3).getType());

    }

    @Test
    void findActivityById() {

        activityDao.saveActivity(biking);
        activityDao.saveActivity(basketball);
        activityDao.saveActivity(running);
        activityDao.saveActivity(hiking);

        assertEquals(1, activityDao.findActivityById(1).getId());
        assertEquals(2, activityDao.findActivityById(2).getId());
        assertEquals(3, activityDao.findActivityById(3).getId());
        assertEquals(4, activityDao.findActivityById(4).getId());

    }

    @Test
    void saveTrackpoints() {
        activityDao.saveActivity(biking);
        activityDao.saveActivity(basketball);
        activityDao.saveActivity(running);
        hiking.setTrackPoints(szepenSorban);
        activityDao.saveActivity(hiking);

        var actual = activityDao.findActivityById(4);

        assertEquals(6, actual.getTrackPoints().size());
        assertEquals(12, actual.getTrackPoints().get(0).getLat(), 0.4);
        assertEquals(13, actual.getTrackPoints().get(1).getLat(), 0.4);
    }

    @Test
    void saveImageToActivity() {

        activityDao.saveActivity(biking);
        activityDao.saveImageToActivity(1, new Image("biking.jpg"));
        activityDao.saveActivity(basketball);
        activityDao.saveImageToActivity(2, new Image("basketball.jpg"));
        activityDao.saveActivity(running);
        activityDao.saveImageToActivity(3, new Image("running.jpg"));

        activityDao.saveActivity(hiking);
        Image expected = new Image("hiking.jpg");
        activityDao.saveImageToActivity(4, expected);

        String filename = "src/test/resources/activitytracker/hiking.jpg";
        assertArrayEquals(expected.getContent(), activityDao.loadImageToActivity(4, filename).getContent());

    }
}
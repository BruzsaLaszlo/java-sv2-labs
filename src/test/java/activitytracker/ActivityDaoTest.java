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

class ActivityDaoTest {

    ActivityDao activityDao;

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
            new TrackPoint(now().withNano(0).minusDays(9), 15.323232, 46.324234));

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

        activityDao = new ActivityDao(mariaDbDataSource);

    }

    @Test
    void saveActivity() {
        activityDao.saveActivity(biking);
        activityDao.saveActivity(basketball);
        activityDao.saveActivity(running);

        hiking.setTrackPoints(szepenSorban);
        Activity actual = activityDao.saveActivity(hiking);

        assertEquals(4, actual.getId());
        assertEquals(4, actual.getTrackPoints().get(3).getId());
    }

    @Test
    void testRollback() {
        biking.setTrackPoints(List.of(new TrackPoint(now(), 90, 180.000001)));

        IllegalStateException iae = assertThrows(IllegalStateException.class, () -> activityDao.saveActivity(biking));
        assertEquals("invalid coordinates", iae.getMessage());
    }

    @Test
    void findActivityById() {
        activityDao.saveActivity(biking);
        activityDao.saveActivity(basketball);
        activityDao.saveActivity(running);
        activityDao.saveActivity(hiking);

        Activity actual = activityDao.findActivityById(1);

        assertSame(BIKING, actual.getType());
        assertEquals(biking, actual);
    }

    @Test
    void listActivities() {
        activityDao.saveActivity(biking);
        activityDao.saveActivity(basketball);

        assertEquals(2, activityDao.listActivities().size());
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
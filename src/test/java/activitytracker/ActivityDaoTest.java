package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

import static activitytracker.SportType.*;
import static java.time.LocalDateTime.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class ActivityDaoTest {

    ActivityDao activityDao;

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


        Activity biking = new Activity(now(),
                "Cycling, also called bicycling or biking, is the use of bicycles for transport, recreation, exercise or sport.",
                BIKING);
        Activity basketball = new Activity(now().minusDays(1),
                "Basketball is a game played between two teams of five players each on a rectangular court, usually indoors.",
                BASKETBALL);
        Activity running = new Activity(now().minusDays(2),
                "Running is a complex, coordinated process which involves the entire body.",
                RUNNING);

        activityDao = new ActivityDao(mariaDbDataSource);

        activityDao.saveActivity(biking);
        activityDao.saveActivity(basketball);
        activityDao.saveActivity(running);

    }

    @Test
    void saveActivity() {
        Activity hiking = new Activity(now().plusDays(1),
                "A long, vigorous walk, usually on trails or footpaths in the countryside.",
                HIKING);

        long id = activityDao.saveActivity(hiking).getId();

        assertEquals(4, id);
    }

    @Test
    void findActivityById() {
        assertSame(BIKING, activityDao.findActivityById(1).getType());
    }

    @Test
    void listActivities() {
        assertEquals(3, activityDao.listActivities().size());
    }
}
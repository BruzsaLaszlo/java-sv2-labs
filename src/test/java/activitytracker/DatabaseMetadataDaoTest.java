package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DatabaseMetadataDaoTest {

    DatabaseMetadataDao databaseMetadataDao;

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

        databaseMetadataDao = new DatabaseMetadataDao(mariaDbDataSource);

    }

    @Test
    void getColumnsForTable() {

        var columnsFlywaySchemaHistory = databaseMetadataDao.getColumnsForTable("flyway_schema_history");
        assertEquals(10, columnsFlywaySchemaHistory.size());

        var columnsActivities = databaseMetadataDao.getColumnsForTable("activities");
        assertEquals(4, columnsActivities.size());
        assertTrue(columnsActivities.contains("id"));
        assertTrue(columnsActivities.contains("start_time"));
        assertTrue(columnsActivities.contains("activity_desc"));
        assertTrue(columnsActivities.contains("activity_type"));

        var columnsImage = databaseMetadataDao.getColumnsForTable("image");
        assertEquals(3, columnsImage.size());
        assertTrue(columnsImage.contains("id"));
        assertTrue(columnsImage.contains("content"));
        assertTrue(columnsImage.contains("activity_id"));

        var columnsTrackPoint = databaseMetadataDao.getColumnsForTable("track_point");
        assertEquals(5, columnsTrackPoint.size());
        assertTrue(columnsTrackPoint.contains("id"));
        assertTrue(columnsTrackPoint.contains("time"));
        assertTrue(columnsTrackPoint.contains("lat"));
        assertTrue(columnsTrackPoint.contains("lon"));
        assertTrue(columnsTrackPoint.contains("activity_id"));

    }
}
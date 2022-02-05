package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static activitytracker.SportType.*;
import static java.time.LocalDateTime.now;

public class ActivityTrackerMain {

    public static void main(String[] args) throws SQLException {

        Activity biking = new Activity(now(),
                "Cycling, also called bicycling or biking, is the use of bicycles for transport, recreation, exercise or sport.",
                BIKING);
        Activity basketball = new Activity(now().minusDays(1),
                "Basketball is a game played between two teams of five players each on a rectangular court, usually indoors.",
                BASKETBALL);
        Activity running = new Activity(now().minusDays(2),
                "Running is a complex, coordinated process which involves the entire body.",
                RUNNING);
        Activity hiking = new Activity(now().plusDays(1),
                "a long, vigorous walk, usually on trails or footpaths in the countryside.",
                HIKING);

        MariaDbDataSource dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
        dataSource.setUser("activitytracker");
        dataSource.setPassword("activitytracker");

        final String preparedInsert =
                "INSERT INTO activitytracker.activities (start_time, activity_desc, activity_type) VALUES (?, ?, ?);";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(preparedInsert)) {
            createTable(conn);

            insertActivity(biking, pstmt);
            insertActivity(basketball, pstmt);
            insertActivity(running, pstmt);
            insertActivity(hiking, pstmt);

            Activity resultActivity = getActivityById(1, conn);
            System.out.println(resultActivity);

            List<Activity> activities = getAllActivity(conn);
            activities.forEach(System.out::println);
        } catch (SQLException e) {
            throw new IllegalStateException("execute failed", e);
        }
    }

    private static List<Activity> getAllActivity(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery("select * from activitytracker.activities")) {
            List<Activity> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(activityFromResultSet(resultSet));
            }
            return result;
        }
    }

    private static Activity activityFromResultSet(ResultSet resultSet) throws SQLException {
        int resultId = resultSet.getInt(1);
        LocalDateTime resultDate = resultSet.getTimestamp(2).toLocalDateTime();
        String resultDesc = resultSet.getString(3);
        SportType resultType = SportType.valueOf(resultSet.getString(4));
        return new Activity(resultId, resultDate, resultDesc, resultType);
    }

    private static Activity getActivityById(int id, Connection conn) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(
                "select * from activitytracker.activities where id = ?")) {
            pstmt.setInt(1, id);
            if (pstmt.execute()) {
                try (ResultSet resultSet = pstmt.getResultSet()) {
                    if (!resultSet.next()) throw new IllegalArgumentException("no activity with id " + id);
                    return activityFromResultSet(resultSet);
                }
            }
        }
        throw new IllegalArgumentException("something bad...");
    }

    private static void insertActivity(Activity activity, PreparedStatement pstmt) throws SQLException {
        pstmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
        pstmt.setString(2, activity.getDesc());
        pstmt.setString(3, activity.getType().toString());
        pstmt.execute();
    }

    private static void createTable(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("drop table if exists activitytracker.activities;");
            stmt.execute(getCreateTableSqlString());
        } catch (SQLSyntaxErrorException ex) {
            throw new IllegalStateException("cant create table", ex);
        }
    }

    private static String getCreateTableSqlString() {
        return """
                CREATE TABLE activitytracker.activities (
                    id INT NOT NULL AUTO_INCREMENT,
                    start_time DATETIME NOT NULL,
                    activity_desc VARCHAR(255) NOT NULL,
                    activity_type VARCHAR(45) NOT NULL,
                    PRIMARY KEY (id))
                  DEFAULT CHARACTER SET = utf8
                  COLLATE = utf8_hungarian_ci;
                """;
    }

}

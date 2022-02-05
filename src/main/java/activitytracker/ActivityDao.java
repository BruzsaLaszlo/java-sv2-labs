package activitytracker;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    private DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Activity saveActivity(Activity activity) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO activities (start_time, activity_desc, activity_type) VALUES (?, ?, ?);",
                     Statement.RETURN_GENERATED_KEYS)
        ) {
            pstmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            pstmt.setString(2, activity.getDesc());
            pstmt.setString(3, activity.getType().name());
            if (pstmt.executeUpdate() != 1) {
                throw new IllegalStateException("insert failed");
            }
            activity.setId(getGeneratedKey(pstmt));
            return activity;
        } catch (SQLException e) {
            throw new IllegalStateException("cant execute", e);
        }
    }

    public Activity findActivityById(int id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("select * from activities where id = ?;")
        ) {
            pstmt.setInt(1, id);
            return getActivity(pstmt);
        } catch (SQLException e) {
            throw new IllegalStateException("cant execute", e);
        }
    }

    public List<Activity> listActivities() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from activities;")
        ) {
            List<Activity> result = new ArrayList<>();
            while (rs.next()) {
                result.add(getActivity(rs));
            }
            return result;
        } catch (SQLException e) {
            throw new IllegalStateException("cant execute");
        }
    }

    private Activity getActivity(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        LocalDateTime startTime = rs.getTimestamp("start_time").toLocalDateTime();
        String desc = rs.getString("activity_desc");
        SportType type = SportType.valueOf(rs.getString("activity_type"));
        return new Activity(id, startTime, desc, type);
    }

    private Activity getActivity(PreparedStatement pstmt) {
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return getActivity(rs);
            }
            throw new IllegalArgumentException("id not found");
        } catch (SQLException e) {
            throw new IllegalStateException("execute failed", e);
        }
    }

    private long getGeneratedKey(PreparedStatement pstmt) throws SQLException {
        try (ResultSet rs = pstmt.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
            throw new SQLException("no generated keys");
        }
    }
}

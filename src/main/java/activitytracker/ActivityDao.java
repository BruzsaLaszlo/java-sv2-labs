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
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);
            return saveActivity(activity, conn);
        } catch (SQLException e) {
            throw new IllegalStateException("connection problem", e);
        }
    }

    private Activity saveActivity(Activity activity, Connection conn) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(
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
            if (!activity.getTrackPoints().isEmpty()) {
                validateTrackPoints(activity.getTrackPoints());
                saveTrackPoints(activity.getTrackPoints(), conn, activity.getId());
            }
            conn.commit();
            return activity;
        } catch (IllegalArgumentException iae) {
            conn.rollback();
            throw new IllegalStateException(iae.getMessage(), iae);
        }
    }

    public Activity findActivityById(int id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("select * from activities where id = ?;")
        ) {
            pstmt.setInt(1, id);
            return getActivity(pstmt, conn);
        } catch (SQLException e) {
            throw new IllegalStateException("cant select", e);
        }
    }

    public void saveImageToActivity(long activityId, Image image) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO image(content, activity_id) VALUES (?,?)",
                     Statement.RETURN_GENERATED_KEYS)
        ) {
            Blob blob = conn.createBlob();
            blob.setBytes(1, image.getContent());
            stmt.setBlob(1, blob);
            stmt.setLong(2, activityId);
            stmt.executeUpdate();
            image.setId(getGeneratedKey(stmt));
        } catch (SQLException e) {
            throw new IllegalStateException("insert failed", e);
        }
    }

    public Image loadImageToActivity(long activityId, String filename) {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM image WHERE activity_id = " + activityId)
        ) {
            rs.next();
            long id = rs.getLong("id");
            Blob blob = rs.getBlob("content");
            return new Image(id, filename, blob.getBinaryStream());
        } catch (SQLException e) {
            throw new IllegalStateException("cant select", e);
        }
    }

    public List<Activity> listActivities() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from activities;")
        ) {
            List<Activity> result = new ArrayList<>();
            while (rs.next()) {
                result.add(getActivity(rs, conn));
            }
            return result;
        } catch (SQLException e) {
            throw new IllegalStateException("cant select", e);
        }
    }

    private Activity getActivity(PreparedStatement pstmt, Connection conn) {
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return getActivity(rs, conn);
            }
            throw new IllegalArgumentException("id not found");
        } catch (SQLException e) {
            throw new IllegalStateException("execute failed", e);
        }
    }

    private Activity getActivity(ResultSet rs, Connection conn) throws SQLException {
        long id = rs.getLong("id");
        LocalDateTime startTime = rs.getTimestamp("start_time").toLocalDateTime();
        String desc = rs.getString("activity_desc");
        SportType type = SportType.valueOf(rs.getString("activity_type"));
        List<TrackPoint> trackPoints = getTrackPoints(id, conn);
        return new Activity(id, startTime, desc, type, trackPoints);
    }

    private List<TrackPoint> getTrackPoints(long id, Connection conn) {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM track_point WHERE id = " + id)
        ) {
            List<TrackPoint> result = new ArrayList<>();
            while (rs.next()) {
                long tpId = rs.getLong("id");
                LocalDateTime time = rs.getTimestamp("time").toLocalDateTime();
                double lat = rs.getDouble("lat");
                double lon = rs.getDouble("lon");
                result.add(new TrackPoint(tpId, time, lat, lon));
            }
            return result;
        } catch (SQLException e) {
            throw new IllegalStateException("cant select trackpoint with id: " + id);
        }
    }

    private void saveTrackPoints(List<TrackPoint> trackPoints, Connection conn, long id) {
        try (PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO track_point(time, lat, lon, activity_id) VALUES (?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS)
        ) {
            for (TrackPoint trackPoint : trackPoints) {
                stmt.setTimestamp(1, Timestamp.valueOf(trackPoint.getTime()));
                stmt.setDouble(2, trackPoint.getLat());
                stmt.setDouble(3, trackPoint.getLon());
                stmt.setLong(4, id);
                stmt.executeUpdate();
                trackPoint.setId(getGeneratedKey(stmt));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("cant insert", e);
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

    private void validateTrackPoints(List<TrackPoint> trackPoints) {
        trackPoints.forEach(tp -> {
            if (tp.getLat() > 90 || tp.getLat() < -90 || tp.getLon() > 180 || tp.getLon() < -180) {
                throw new IllegalArgumentException("invalid coordinates");
            }
        });
    }
}

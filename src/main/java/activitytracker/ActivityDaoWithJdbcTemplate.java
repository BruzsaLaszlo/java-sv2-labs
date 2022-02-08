package activitytracker;


import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class ActivityDaoWithJdbcTemplate {

    JdbcTemplate jdbcTemplate;

    public ActivityDaoWithJdbcTemplate(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Activity saveActivity(Activity activity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> getActivityPreparedStatement(activity, con), keyHolder);
        long activityId = Objects.requireNonNull(keyHolder.getKey()).longValue();
        activity.setId(activityId);
        saveTrackPoints(activity.getTrackPoints(), activityId);
        return activity;
    }

    private void saveTrackPoints(List<TrackPoint> trackPoints, long activityId) {
        String sql = "INSERT INTO track_point(time, lat, lon, activity_id) VALUES (?,?,?,?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                var trackPoint = trackPoints.get(i);
                ps.setTimestamp(1, Timestamp.valueOf(trackPoint.getTime()));
                ps.setDouble(2, trackPoint.getLat());
                ps.setDouble(3, trackPoint.getLon());
                ps.setLong(4, activityId);
            }

            @Override
            public int getBatchSize() {
                return trackPoints.size();
            }
        });
    }

    public Activity findActivityById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM activities WHERE id =" + id, this::getActivity);
    }

    public List<Activity> listActivities() {
        return jdbcTemplate.queryForStream("SELECT * FROM activities", this::getActivity).toList();
    }

    private Activity getActivity(ResultSet rs, int rowNum) throws SQLException {
        long id = rs.getLong("id");
        LocalDateTime startTime = rs.getTimestamp("start_time").toLocalDateTime();
        String desc = rs.getString("activity_desc");
        SportType type = SportType.valueOf(rs.getString("activity_type"));
        List<TrackPoint> trackPoints = getTrackPoints(id);
        return new Activity(id, startTime, desc, type, trackPoints);
    }

    private List<TrackPoint> getTrackPoints(long activityId) {
        String sql = "SELECT * FROM track_point WHERE activity_id = " + activityId;
        return jdbcTemplate.queryForStream(sql, this::getTrackPoint).toList();
    }

    private TrackPoint getTrackPoint(ResultSet rs, int rowNum) throws SQLException {
        long tpId = rs.getLong("id");
        LocalDateTime time = rs.getTimestamp("time").toLocalDateTime();
        double lat = rs.getDouble("lat");
        double lon = rs.getDouble("lon");
        return new TrackPoint(tpId, time, lat, lon);
    }

    private PreparedStatement getActivityPreparedStatement(Activity activity, Connection con) {
        String sql = "INSERT INTO activities(start_time, activity_desc, activity_type) VALUES (?,?,?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql, RETURN_GENERATED_KEYS);
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getType().name());
            return stmt;
        } catch (SQLException sqle) {
            throw new IllegalStateException("cant create PreparedStatement", sqle);
        }
    }

    public void saveImageToActivity(long activityId, Image image) {
        String sql = "INSERT INTO image(content,activity_id) VALUES (?," + activityId + ")";
        jdbcTemplate.update(con -> {
            Blob blob = con.createBlob();
            blob.setBytes(1, image.getContent());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBlob(1, blob);
            return ps;
        });
    }

    public Image loadImageToActivity(long activityId, String filename) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM image WHERE activity_id=" + activityId,
                (rs, rowNum) -> {
                    long id = rs.getLong("id");
                    InputStream is = rs.getBlob("content").getBinaryStream();
                    return new Image(id, filename, is);
                });
    }

}

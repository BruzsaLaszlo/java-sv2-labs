package activitytracker;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseMetadataDao {

    private DataSource dataSource;

    public DatabaseMetadataDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getColumnsForTable(String table) {
        try (Connection conn = dataSource.getConnection()) {
            DatabaseMetaData databaseMetaData = conn.getMetaData();
            return getTables(databaseMetaData, table);
        } catch (SQLException e) {
            throw new IllegalStateException("connection failed,", e);
        }
    }

    private List<String> getTables(DatabaseMetaData databaseMetaData, String table) {
        try (ResultSet rs =
                     databaseMetaData.getColumns(null, null, table, null)) {
            List<String> result = new ArrayList<>();
            while (rs.next()) {
                result.add(rs.getString(4));
            }
            return result;
        } catch (SQLException sqle) {
            throw new IllegalStateException("no result", sqle);
        }
    }

}

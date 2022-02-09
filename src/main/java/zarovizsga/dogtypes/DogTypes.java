package zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DogTypes {

    DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public List<String> getDogsByCountry(String country) {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name,country FROM dog_types")
        ) {
            List<String> result = new ArrayList<>();
            while (rs.next()) {
                if (rs.getString("country").equalsIgnoreCase(country)) {
                    result.add(rs.getString("name").toLowerCase());
                }
            }
            Collections.sort(result);
            return result;
        } catch (SQLException e) {
            throw new IllegalStateException("cant select", e);
        }
    }
}

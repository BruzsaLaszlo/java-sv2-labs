package kepesitovizsga.jurassic;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class JurassicPark {

    private DataSource dataSource;

    public JurassicPark(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public List<String> checkOverpopulation() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from dinosaur;")) {

            List<String> result = new ArrayList<>();
            while (rs.next()) {
                getNextNameFrom(rs).ifPresent(result::add);
            }

            Collections.sort(result);
            return result;
        } catch (SQLException e) {
            throw new IllegalArgumentException("sql problem", e);
        }
    }

    private Optional<String> getNextNameFrom(ResultSet resultSet) throws SQLException {
        String breed = resultSet.getString("breed");
        int expected = resultSet.getInt("expected");
        int actual = resultSet.getInt("actual");
        return actual > expected ? Optional.of(breed) : Optional.empty();

    }

}

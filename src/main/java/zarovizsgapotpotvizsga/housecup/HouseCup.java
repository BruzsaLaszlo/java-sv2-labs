package zarovizsgapotpotvizsga.housecup;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class HouseCup {

    JdbcTemplate jdbcTemplate;

    public HouseCup(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public int getPointsOfHouse(String house) {
        List<Integer> points = jdbcTemplate.queryForList(
                "SELECT points_earned FROM house_points WHERE house_name = ?",
                Integer.class,
                house);

        return points.stream()
                .mapToInt(value -> value)
                .sum();
    }
}

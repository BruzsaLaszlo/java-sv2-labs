package zarovizsgapotvizsga.peoplesql;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class PeopleDao {

    JdbcTemplate jdbcTemplate;

    public PeopleDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String findIpByName(String firstName, String lastName) {
        return jdbcTemplate.queryForObject("""
                        SELECT ip_address
                        FROM employees.people
                        WHERE first_name LIKE ? AND last_name LIKE ?""",
                String.class,
                firstName, lastName);
    }
}

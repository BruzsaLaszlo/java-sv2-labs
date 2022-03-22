package zarovizsgapotvizsga2021.message;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepository {

    private JdbcTemplate jdbcTemplate;

    public UserRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void insertUser(String username) {
        jdbcTemplate.update("INSERT INTO `exam-test`.users(username) VALUES (?)", username);
    }

    public Optional<User> findUserByName(String username) {
        User user = jdbcTemplate.query(
                "SELECT * FROM `exam-test`.users WHERE username LIKE ?",
                this::getUser,
                username);

        return Optional.ofNullable(user);
    }

    private User getUser(ResultSet rs) throws SQLException {
        return rs.next()
                ? new User(rs.getLong("id"), rs.getString("username"))
                : null;
    }

}

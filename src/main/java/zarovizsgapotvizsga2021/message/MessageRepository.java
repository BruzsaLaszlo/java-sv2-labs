package zarovizsgapotvizsga2021.message;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MessageRepository {

    private JdbcTemplate jdbcTemplate;

    public MessageRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveMessage(long senderId, long receiverId, String message) {
        jdbcTemplate.update("""
                INSERT INTO `exam-test`.messages(sender_id, receiver_id, message)
                VALUES (?,?,?)""", senderId, receiverId, message);
    }

    public List<String> findMessagesBySenderId(long senderId) {
        return jdbcTemplate.query("SELECT * FROM `exam-test`.messages WHERE sender_id = ?",
                this::getMessage,
                senderId);
    }

    private String getMessage(ResultSet resultSet, int rowNum) throws SQLException {
        return resultSet.getString("message");
    }

}

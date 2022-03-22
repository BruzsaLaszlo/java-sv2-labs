package zarovizsgapotpotvizsga2021.settlers;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.*;

public class SettlerRepository {

    JdbcTemplate jdbcTemplate;

    public SettlerRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public long saveNewSettler(Settler settler) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> getPreparedStatement(con, settler), keyHolder);
        return keyHolder.getKey().longValue();
    }

    private PreparedStatement getPreparedStatement(Connection con, Settler settler) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO settlers(name_of_settler,amount_of_tobacco,expected_income) VALUES (?,?,?)",
                Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, settler.getNameOfSettler());
        stmt.setInt(2, settler.getAmountOfTobacco());
        stmt.setInt(3, settler.getExpectedIncome());
        return stmt;
    }

    public Settler findSettlerById(int id) {
        return jdbcTemplate.query(
                "SELECT * FROM settlers WHERE id = ?",
                this::getSettler,
                id
        );
    }

    private Settler getSettler(ResultSet rs) throws SQLException {
        if (!rs.next()) {
            throw new IllegalArgumentException("Can not found id!");
        }
        return new Settler(rs.getString("name_of_settler"), rs.getInt("amount_of_tobacco"));
    }

    public void updateGrowthAndIncome(long id, int amount) {
        jdbcTemplate.update("""
                UPDATE settlers
                SET amount_of_tobacco = amount_of_tobacco - ?
                WHERE id = ?
                """, amount, id);
    }
}

package kepesitovizsgapotvizsga.webshop;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WebshopService {

    private DataSource dataSource;

    public WebshopService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getValuableCustomers() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet resultset = stmt.executeQuery("select * from orders;")) {
            List<String> result = new ArrayList<>();
            while (resultset.next()) {
                String name = resultset.getString("customer_name");
                int total = resultset.getInt("total");
                if (total > 1000) {
                    result.add(name);
                }
            }
            result.sort(String::compareTo);
            return result;
        } catch (SQLException e) {
            throw new IllegalStateException("sql ex", e);
        }
    }
}

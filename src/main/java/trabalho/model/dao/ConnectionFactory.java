package trabalho.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by rodrigo on 04/05/17.
 */
public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            String url = "jdbc:postgresql://localhost:5432/controle_de_estoque";
            return DriverManager.getConnection(url, "postgres", "1096");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

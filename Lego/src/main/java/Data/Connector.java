package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The purpose of Connector is to...
 *
 * @author kasper
 */
public class Connector {

    private static final String URL = "jdbc:mysql://207.154.240.48:3306/useradmin";
    private static final String USERNAME = "guest";
    private static final String PASSWORD = "1234";

    private static Connection singleton;

    public static void setConnection(Connection con) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if (singleton == null) {
            Class.forName("com.mysql.jdbc.Driver");
            singleton = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return singleton;
    }

}

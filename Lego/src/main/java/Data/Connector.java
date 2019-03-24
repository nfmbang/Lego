package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The purpose of Connector is to...
 *
 * @author kasper
 */
class Connector {

    private static final String URL = "jdbc:mysql://207.154.240.48:3306/useradmin";
    private static final String USERNAME = "guest";
    private static final String PASSWORD = "1234";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static Connection singleton;

    static void setConnection(Connection con) {
        singleton = con;
    }

    static Connection connection() throws ClassNotFoundException, SQLException {
        if (singleton == null) {
            Class.forName(DRIVER);

            singleton = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return singleton;
    }

}

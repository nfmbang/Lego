package Data;

import Logic.LoginSampleException;
import Logic.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class UserMapperTest {
//    Test date in the UsersTest table
//    INSERT INTO `UsersTest` VALUES
//    (1,'jens@somewhere.com','jensen','customer'),
//    (2,'ken@somewhere.com','kensen','customer'),
//    (3,'robin@somewhere.com','batman','employee'),
//    (4,'someone@nowhere.com','sesam','customer');

    private static Connection testConnection;
    private static String USER = "guest";
    private static String USERPW = "1234";
    private static String DBNAME = "useradmin";
    private static String HOST = "207.154.240.48";

    @Before
    public void setUp() {
        try {
            // avoid making a new connection for each test
            if (testConnection == null) {
                String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
                Class.forName("com.mysql.jdbc.Driver");

                testConnection = DriverManager.getConnection(url, USER, USERPW);
                // Make mappers use test
                //testConnection = DriverManager.getConnection("jdbc:mysql://207.154.240.48:3306/useradmin?" + "user=guest&password=1234");
                Connector.setConnection(testConnection);
            }

            // reset test database
            try (Statement stmt = testConnection.createStatement()) {
                stmt.execute("drop table if exists Users");
                stmt.execute("create table Users like UsersTest");
                stmt.execute("insert into Users select * from UsersTest");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            testConnection = null;
            System.out.println("Could not open connection to database: " + ex.getMessage());
            System.out.println("SQLException: " + ex.getMessage());
            if (ex instanceof SQLException) {
                System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
                System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
            }
        }
    }

    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull(testConnection);
    }

    @Test
    public void testLogin01() throws LoginSampleException {
        // Can we log in
        User user = UserMapper.login("jens@somewhere.com", "jensen");
        assertTrue(user != null);
    }

    @Test(expected = LoginSampleException.class)
    public void testLogin02() throws LoginSampleException {
        // We should get an exception if we use the wrong password
        User user = UserMapper.login("jens@somewhere.com", "larsen");
    }

    @Test
    public void testLogin03() throws LoginSampleException {
        // Jens is supposed to be a customer
        User user = UserMapper.login("jens@somewhere.com", "jensen");
        assertEquals("customer", user.getRole());
    }

    @Test
    public void testCreateUser01() throws LoginSampleException {
        // Can we create a new user - Notice, if login fails, this will fail
        // but so would login01, so this is OK
        User original = new User("king@kong.com", "uhahvorhemmeligt", "konge");
        UserMapper.createUser(original);
        User retrieved = UserMapper.login("king@kong.com", "uhahvorhemmeligt");
        assertEquals("konge", retrieved.getRole());
    }
}

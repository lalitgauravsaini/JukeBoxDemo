package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SuppressWarnings("ALL")
public class DB_connection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/JukeBox";
        Connection connection = DriverManager.getConnection(url, "root", "admin");

        if (connection != null) {

            // System.out.println("CONNECTED TO DATABASE SUCCESSFULLY");

        }
        return connection;
    }
}

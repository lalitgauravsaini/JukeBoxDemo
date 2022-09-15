package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_connection {

        public static Connection getConnection() throws ClassNotFoundException, SQLException {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/JukeBox";
            Connection connection = DriverManager.getConnection(url, "root", "Arjun@123");
            if(connection != null){
                System.out.println("CONNECTED SUCCESSFULLY");
            }
            return connection;
        }
}

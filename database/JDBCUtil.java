package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection(){
        Connection connection = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            String username ="root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/drug_dispensing_management";
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException e){
            e.getStackTrace();
        }
        return connection;
    }
    public static void closeConnection(Connection connection){
        try {
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e){
            e.getStackTrace();
        }
    }
}

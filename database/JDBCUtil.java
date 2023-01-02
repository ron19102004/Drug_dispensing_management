package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection(){
        Connection connection = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            String USERNAME ="root";
            String PASSWORD = "";
            String DATABASE="drug_dispensing_management";
            String url = "jdbc:mysql://localhost:3306/"+DATABASE;
            connection = DriverManager.getConnection(url,USERNAME,PASSWORD);
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

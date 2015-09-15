package database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    //private static final String URL = "jdbc:mysql://localhost:3306/ishop";
    private static final String URL = "jdbc:mysql://localhost:3306/ticket_store";
    private static final String LOGIN = "root";
    //private static final String LOGIN = "comicat";
    private static final String PASSWORD = "1111";
    //private static final String PASSWORD = "qwertyZXCVBN9";
    Connection connection;

    public DBConnector() {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Class not found in DBWorker Class.forName");
            }
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("EXEPTION: Driver is not found");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}

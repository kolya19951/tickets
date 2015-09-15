package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWorker {
    Connection connection;
    Statement statement;

    public DBWorker() {
        DBConnector dbConnector= new DBConnector();
        connection = dbConnector.getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("EXCEPTION: Statement was not created.");
        }
    }

    public String getData (String table, String column, int id) {
        String query = "SELECT * FROM " + table + " WHERE id = " + id;
        try {
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            return resultSet.getString(column);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("EXCEPTION: No such data in DB");
            return "";
        }
    }

    public ResultSet getTable(String table) {
        String query = "SELECT * FROM " + table;
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("EXCEPTION: No such data in DB");
        }
        return resultSet;
    }

    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("EXCEPTION in execution query(Select)");
        }
        return  resultSet;
    }

    public void execute(String query) {
        try {
            statement.execute(query);
            //resultSet.next();
            //System.out.println(resultSet.getString(1));
            //System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("executing query is failed!");
        }
    }

    public int selectIntByString(String table, String column, String param_name, String param_value) {
        int res = 0;
        String query = "SELECT " + column + " FROM " + table + "WHERE " + param_name + " = '" + param_value + "'";
        try {
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()) {
                res = resultSet.getInt(column);
            } else {
                System.out.println("No such data in DB");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("EXCEPTION: No such data in DB");
        }
        return res;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("EXCEPTION: Connection was not closed!");
            e.printStackTrace();
        }
    }
}

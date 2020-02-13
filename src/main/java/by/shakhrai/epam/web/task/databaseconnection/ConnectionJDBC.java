package by.shakhrai.epam.web.task.databaseconnection;

import by.shakhrai.epam.web.task.exception.ConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static by.shakhrai.epam.web.task.databaseconnection.MySQLInit.*;

public class ConnectionJDBC {

    private static Connection connection;

    static {
        try {
            Class.forName(DB_DRIVER).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Loading driver ERROR " + e);
        }
    }

    public static synchronized Connection getConnection() throws ConnectionException {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL, USER_LOGIN, USER_PASS);

            }
        } catch (SQLException e) {
            throw new ConnectionException();
        }
        System.out.println("get connect" + connection);
        return connection;
    }


}

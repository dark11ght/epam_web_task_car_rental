package by.shakhrai.epam.web.task.databaseconnection.impl;

import by.shakhrai.epam.web.task.databaseconnection.ConnectionPool;
import java.sql.Connection;

public class DataSource {
    private static ConnectionPool connectionPool = ConnectionPoolImpl.create();

    public static Connection getConnection() {
        Connection connection = connectionPool.getConnection();
        return connection;
    }

    public static void releaseConnection(Connection connection){
        connectionPool.releaseConnection(connection);
    }



}

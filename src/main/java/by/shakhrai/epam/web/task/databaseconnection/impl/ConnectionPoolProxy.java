package by.shakhrai.epam.web.task.databaseconnection.impl;

import by.shakhrai.epam.web.task.databaseconnection.ConnectionPool;
import by.shakhrai.epam.web.task.exception.ConnectionException;

import java.sql.Connection;

public class ConnectionPoolProxy {
    private static ConnectionPool connectionPool;

    static {
        try {
            connectionPool = ConnectionPoolImpl.initConnectionPool();
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connectionPool.getConnection();
    }

    public static void releaseConnection(Connection connection){
        connectionPool.releaseConnection(connection);
    }


}

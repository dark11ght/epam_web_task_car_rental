package by.shakhrai.epam.web.task.databaseconnection.impl;

import by.shakhrai.epam.web.task.databaseconnection.ConnectionPool;

import java.sql.Connection;

public class ConnectionPoolUse {
    private static ConnectionPool connectionPool = ConnectionPoolImpl.create();

    public static Connection getConnection() {
        return connectionPool.getConnection();
    }

    public static void releaseConnection(Connection connection){
        connectionPool.releaseConnection(connection);
    }


}

package by.shakhrai.epam.web.task.databaseconnection.impl;

import by.shakhrai.epam.web.task.databaseconnection.ConnectionPool;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.shakhrai.epam.web.task.databaseconnection.impl.MySQLInit.*;


public class ConnectionPoolImpl implements ConnectionPool {

    private List<Connection> connectionPoll;
    private List<Connection> usedConnection = new ArrayList<>();

    private static void init() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static ConnectionPoolImpl create() {
        ConnectionPoolImpl.init();
        List<Connection> pool = new ArrayList<>(MAX_POOL);
        for (int i = 0; i < MAX_POOL; i++) {
            pool.add(createConnection());
        }
        return new ConnectionPoolImpl(pool);
    }

    private ConnectionPoolImpl(List<Connection> connectionPoll) {
        this.connectionPoll = connectionPoll;
    }

    @Override
    public Connection getConnection() {
        Connection connection = connectionPoll.remove(connectionPoll.size() - 1);
        usedConnection.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPoll.add(connection);
        return usedConnection.remove(connection);
    }

    private static Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER_LOGIN, USER_PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public int getSize() {
        return connectionPoll.size() + usedConnection.size();
    }
}
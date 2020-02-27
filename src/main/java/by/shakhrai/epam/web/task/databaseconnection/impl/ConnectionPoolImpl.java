package by.shakhrai.epam.web.task.databaseconnection.impl;

import by.shakhrai.epam.web.task.databaseconnection.ConnectionPool;
import by.shakhrai.epam.web.task.exception.ConnectionException;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static by.shakhrai.epam.web.task.databaseconnection.impl.MySQLInit.*;


public class ConnectionPoolImpl implements ConnectionPool {
    private static ConnectionPoolImpl instance;

    private List<Connection> connectionPoll;
    private List<Connection> usedConnection = new ArrayList<>();
    private static AtomicBoolean isNullConnectionPool = new AtomicBoolean(true);



    private ConnectionPoolImpl(List<Connection> connectionPoll) {
        this.connectionPoll = connectionPoll;
    }

    static ConnectionPoolImpl initConnectionPool() throws ConnectionException {
        if (isNullConnectionPool.get()) {
            ConnectionPoolImpl.init();
            return ConnectionPoolImpl.create();
        }
        return instance;
    }


    private static void init() throws ConnectionException {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new ConnectionException("DB_Driver not found");
        }
    }

    private static ConnectionPoolImpl create() throws ConnectionException {
        List<Connection> pool = new ArrayList<>(MAX_POOL);
        for (int i = 0; i < MAX_POOL; i++) {
            pool.add(createConnection());
        }

        return instance = new ConnectionPoolImpl(pool);
    }

    private static Connection createConnection() throws ConnectionException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER_LOGIN, USER_PASS);
        } catch (SQLException e) {
            throw new ConnectionException("Connection is fail");
        }
        return connection;
    }

    public int getSize() {
        return connectionPoll.size() + usedConnection.size();
    }

    @Override
    public Connection getConnection() throws ConnectionException {
        if (connectionPoll.size() != 0){
            Connection connection = connectionPoll.remove(connectionPoll.size() - 1);
            usedConnection.add(connection);
            return connection;
        }
        throw new ConnectionException("ConnectionPool is empty");
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPoll.add(connection);
        return usedConnection.remove(connection);
    }

}
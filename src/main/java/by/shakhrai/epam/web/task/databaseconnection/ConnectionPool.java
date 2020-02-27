package by.shakhrai.epam.web.task.databaseconnection;


import by.shakhrai.epam.web.task.exception.ConnectionException;

import java.sql.Connection;
import java.util.List;

public interface ConnectionPool {

    Connection getConnection() throws ConnectionException;

    boolean releaseConnection(Connection connection);


}

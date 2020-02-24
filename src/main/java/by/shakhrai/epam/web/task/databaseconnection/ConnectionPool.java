package by.shakhrai.epam.web.task.databaseconnection;


import java.sql.Connection;

public interface ConnectionPool {


    Connection getConnection();

    boolean releaseConnection(Connection connection);


}

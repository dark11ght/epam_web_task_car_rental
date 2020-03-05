package by.shakhrai.epam.web.task.dao.impl;

import by.shakhrai.epam.web.task.connectionpool.ConnectionPool;
import by.shakhrai.epam.web.task.connectionpool.ConnectionProxy;
import by.shakhrai.epam.web.task.dao.RoleDAO;
import by.shakhrai.epam.web.task.dao.UserDAO;
import by.shakhrai.epam.web.task.exception.DAOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoleDAOImpl implements RoleDAO {
    private static final Logger LOGGER = LogManager.getLogger(RoleDAOImpl.class);

    @Override
    public void addUserRole(String newRole) throws DAOException {
        try (
                ConnectionProxy connection = new ConnectionProxy(ConnectionPool.INSTANCE.getConnection());
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO role (role) " +
                        "VALUES (?);")
        ) {
            preparedStatement.setString(1, newRole);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn(e);
            throw new DAOException("Can`t get cars list");
        }

    }
}
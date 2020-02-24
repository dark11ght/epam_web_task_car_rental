package by.shakhrai.epam.web.task.dao.impl;

import by.shakhrai.epam.web.task.dao.UserDAO;
import by.shakhrai.epam.web.task.databaseconnection.impl.ConnectionPoolUse;
import by.shakhrai.epam.web.task.entity.Role;
import by.shakhrai.epam.web.task.entity.User;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAOImpl implements UserDAO {

    public UserDAOImpl() {
    }

    @Override
    public User getUserByLogin(String login) {
        User user = new User();
        String query = "SELECT user.id, login, password, role, active_status FROM user " +
                "INNER JOIN role r ON user.role_id = r.id WHERE user.login = ";
        Connection connection = ConnectionPoolUse.getConnection();

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(query + "\'" + login + "\'");
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            if (resultSet.next()) {
                Role role = new Role();
                role.setRole(resultSet.getString("role"));
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(role);
                user.setActiveStatus(resultSet.getBoolean("active_status"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPoolUse.releaseConnection(connection);
        }

        return user;

    }
}

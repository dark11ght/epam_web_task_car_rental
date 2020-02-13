package by.shakhrai.epam.web.task.dao.impl;

import by.shakhrai.epam.web.task.dao.AbstractGenericDAO;
import by.shakhrai.epam.web.task.dao.UserDAO;
import by.shakhrai.epam.web.task.databaseconnection.ConnectionJDBC;
import by.shakhrai.epam.web.task.entity.Role;
import by.shakhrai.epam.web.task.entity.User;
import by.shakhrai.epam.web.task.exception.ConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl extends AbstractGenericDAO<User> implements UserDAO {
    private ConnectionJDBC connectionJDBC;

    public UserDAOImpl(ConnectionJDBC connectionJDBC) {
        this.connectionJDBC = connectionJDBC;
    }

    @Override
    public User getUserByLogin(String login) {
        User user = new User();
        String query = "SELECT user.id, login, password, role, active_status FROM user " +
                "INNER JOIN role r on user.role_id = r.id WHERE user.login = ";

        try (
                Connection connection = ConnectionJDBC.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query + "\'" + login + "\'");
                ResultSet resultSet = preparedStatement.executeQuery();

        ) {

            if(resultSet.next()){
                Role role = new Role();
                role.setRole(resultSet.getString("role"));
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(role);
                user.setActiveStatus(resultSet.getBoolean("active_status"));
            }

        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.println(user);
        return user;

    }
}

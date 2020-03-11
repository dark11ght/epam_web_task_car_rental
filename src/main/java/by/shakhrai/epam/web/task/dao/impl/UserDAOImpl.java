package by.shakhrai.epam.web.task.dao.impl;

import by.shakhrai.epam.web.task.dao.UserDAO;
import by.shakhrai.epam.web.task.connectionpool.ConnectionPool;
import by.shakhrai.epam.web.task.connectionpool.ConnectionProxy;
import by.shakhrai.epam.web.task.entity.Role;
import by.shakhrai.epam.web.task.entity.User;
import by.shakhrai.epam.web.task.exception.DAOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAOImpl implements UserDAO {
    private static final Logger LOGGER = LogManager.getLogger(UserDAOImpl.class);
    //fields
    private static final String USER_ROLE = "role";
    private static final String USER_ID = "id";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String ACTIVE_USER_STATUS = "active_status";

    //query
    private static final String GET_USER_BY_LOGIN_QUERY = "SELECT user.id, login, password, role, active_status FROM user " +
            "INNER JOIN role r ON user.role_id = r.id WHERE user.login = ";
    private static final String GET_USER_BY_ID_QUERY = "SELECT user.id, login, password, role, active_status FROM user " +
            "INNER JOIN role r ON user.role_id = r.id WHERE user.id = ";
    private static final String GET_ALL_USERS_QUERY = "SELECT user.id, login, password, role, active_status FROM user " +
            "INNER JOIN role r ON user.role_id = r.id";


    @Override
    public User getUserByID(long id) throws DAOException {
        User user = new User();
        try (
                ConnectionProxy connection = new ConnectionProxy(ConnectionPool.INSTANCE.getConnection());
                PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID_QUERY + id);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            createUserByResultSet(user, resultSet);
        } catch (SQLException e) {
            LOGGER.warn(e);
            throw new DAOException("Can`t get user ");
        }
        return user;
    }


    @Override
    public User getUserByLogin(String login) throws DAOException {
        User user = new User();
        try (
                ConnectionProxy connection = new ConnectionProxy(ConnectionPool.INSTANCE.getConnection());
                PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_LOGIN_QUERY + "\'" + login + "\'");
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            createUserByResultSet(user, resultSet);
        } catch (SQLException e) {
            LOGGER.warn(e);
            throw new DAOException("Can`t get user ");
        }
        return user;
    }

    @Override
    public User getUserBYEmail(String email) throws DAOException {
        return null;
    }

    @Override
    public List<User> getAllUsers() throws DAOException {
        List<User> users = new ArrayList<>();

        try (
                ConnectionProxy connection = new ConnectionProxy(ConnectionPool.INSTANCE.getConnection());
                PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS_QUERY);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                User user = new User();
                Role role = new Role();
                role.setRole(resultSet.getString(USER_ROLE));
                user.setId(resultSet.getLong(USER_ID));
                user.setLogin(resultSet.getString(LOGIN));
                user.setPassword(resultSet.getString(PASSWORD));
                user.setRole(role);
                user.setActiveStatus(resultSet.getBoolean(ACTIVE_USER_STATUS));
                users.add(user);
            }
        } catch (SQLException e) {
            LOGGER.warn(e);
            throw new DAOException("Can`t get users ");
        }
        return users;
    }

    private void createUserByResultSet(User user, ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            Role role = new Role();
            role.setRole(resultSet.getString(USER_ROLE));
            user.setId(resultSet.getLong(USER_ID));
            user.setLogin(resultSet.getString(LOGIN));
            user.setPassword(resultSet.getString(PASSWORD));
            user.setRole(role);
            user.setActiveStatus(resultSet.getBoolean(ACTIVE_USER_STATUS));
        }
    }
}

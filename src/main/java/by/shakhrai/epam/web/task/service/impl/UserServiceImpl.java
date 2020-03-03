package by.shakhrai.epam.web.task.service.impl;

import by.shakhrai.epam.web.task.dao.UserDAO;
import by.shakhrai.epam.web.task.entity.User;
import by.shakhrai.epam.web.task.exception.DAOException;
import by.shakhrai.epam.web.task.factory.DAOFactory;
import by.shakhrai.epam.web.task.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = DAOFactory.INSTANCE.getUserDao();

    public UserServiceImpl() {
    }

    @Override
    public User signIn(String login, String password) {
        User user = null;
        try {
            user = userDAO.getUserByLogin(login);
        } catch (DAOException e) {
            e.printStackTrace();//TODO write Exception
        }
        if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
            return user;
        } else return null;
    }

    @Override
    public User createUser(String login, String password, String email) {
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public void deleteUser(User user) {

    }
}

package by.shakhrai.epam.web.task.service.impl;

import by.shakhrai.epam.web.task.dao.UserDAO;
import by.shakhrai.epam.web.task.entity.User;
import by.shakhrai.epam.web.task.exception.DAOException;
import by.shakhrai.epam.web.task.exception.UserServiceEcxeption;
import by.shakhrai.epam.web.task.factory.DAOFactory;
import by.shakhrai.epam.web.task.service.UserService;
import by.shakhrai.epam.web.task.validator.LoginPasswordValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LogManager.getLogger(UserService.class);
    private UserDAO userDAO = DAOFactory.INSTANCE.getUserDao();

    public UserServiceImpl() {
    }

    @Override
    public User signIn(String login, String password) throws UserServiceEcxeption {
        User user = null;
        if (LoginPasswordValidator.validationLogin(login) && LoginPasswordValidator.validationPassword(password)) {
            try {
                user = userDAO.getUserByLogin(login);
            } catch (DAOException e) {
                LOGGER.warn(e);
                throw new UserServiceEcxeption(e) {
                };
            }
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserServiceEcxeption("Incorrect login or Password");
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

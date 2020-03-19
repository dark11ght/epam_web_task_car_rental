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

import java.util.List;

public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LogManager.getLogger(UserService.class);
    private UserDAO userDAO = DAOFactory.INSTANCE.getUserDao();

    @Override
    public List<User> geaAllUsers() throws UserServiceEcxeption {
        try {
            return userDAO.getAllUsers();
        } catch (DAOException e) {
            LOGGER.warn(e);
            throw new UserServiceEcxeption(e) {
            };
        }
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
            if (user.getLogin() != null) {
                if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                    return user;
                }
            }
        }
        return null;
    }

    @Override
    public void createUser(String login, String password, String first_name, String last_name, String passport_serial_number,
                           String driver_licence_number, String email, String phone_number) throws UserServiceEcxeption {
        try {
            if (userDAO.isUserByLogin(login)) {
                throw new UserServiceEcxeption("Login is used");
            }
        } catch (DAOException e) {
            LOGGER.warn(e);
            throw new UserServiceEcxeption(e);
        }

        try {
            if (userDAO.isUserByEmail(email)) {
                throw new UserServiceEcxeption("Email is used");
            }
        } catch (DAOException e) {
            LOGGER.warn(e);
            throw new UserServiceEcxeption(e);
        }

        try {
            userDAO.registrationUser(login, password, first_name, last_name, passport_serial_number, driver_licence_number,
                    email, phone_number);
        } catch (DAOException e) {
            LOGGER.warn(e);
            throw new UserServiceEcxeption(e);
        }
    }

    @Override
    public User getUserByLogin(String login) throws UserServiceEcxeption {
        User user = null;
        try {
            user = userDAO.getUserByLogin(login);
        } catch (DAOException e) {
            LOGGER.warn(e);
            throw new UserServiceEcxeption(e) {
            };
        }
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserById(long id) throws UserServiceEcxeption {
        User user = null;
        try {
            user = userDAO.getUserByID(id);
        } catch (DAOException e) {
            LOGGER.warn(e);
            throw new UserServiceEcxeption(e) {
            };
        }
        return user;
    }

    @Override
    public void deleteUser(User user) {

    }
}

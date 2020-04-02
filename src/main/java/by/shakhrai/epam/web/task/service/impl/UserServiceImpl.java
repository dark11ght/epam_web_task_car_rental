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
    public List <User> geaAllUsers() throws UserServiceEcxeption {
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
    public void createUser(String login, String password, String firstName, String lastName, String passportSerialNumber,
                           String driverLicenceNumber, String email, String phoneNumber) throws UserServiceEcxeption {
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
            User newUser = buildUser(login, password, firstName, lastName, passportSerialNumber, driverLicenceNumber,
                    email, phoneNumber);
            userDAO.registrationUser(newUser);
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

    @Override
    public void changePassword(long userID, String oldPassword, String newPassword, String repeatPassword) throws UserServiceEcxeption {
        if (LoginPasswordValidator.validationPassword(oldPassword) && LoginPasswordValidator.validationPassword(newPassword) && LoginPasswordValidator.validationPassword(repeatPassword)) {
            if (newPassword.equals(repeatPassword)) {
                User user = getUserById(userID);
                if (oldPassword.equals(user.getPassword())) {
                    try {
                        userDAO.changeUserPassword(userID, newPassword);
                    } catch (DAOException e) {
                        LOGGER.warn(e);
                        throw new UserServiceEcxeption(e);
                    }
                }
            } else {
                throw new UserServiceEcxeption("Passwords do not much");
            }
        } else {
            throw new UserServiceEcxeption("Incorrect password");
        }
    }


    private User buildUser(String login, String password, String firstName, String lastName, String passportSerialNumber,
                           String driverLicenceNumber, String email, String phoneNumber) {
        User user = new User();

        user.setLogin(login);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassportSerialNumber(passportSerialNumber);
        user.setDriverLicenceNumber(driverLicenceNumber);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        return user;
    }
}

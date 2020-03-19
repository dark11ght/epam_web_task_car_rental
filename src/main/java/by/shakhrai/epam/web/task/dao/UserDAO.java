package by.shakhrai.epam.web.task.dao;

import by.shakhrai.epam.web.task.entity.User;
import by.shakhrai.epam.web.task.exception.DAOException;

import java.util.List;

public interface UserDAO {
    void registrationUser(String login, String password, String first_name, String last_name, String passport_serial_number,
                          String driver_licence_number, String email, String phone_number)throws DAOException;

    boolean isUserByLogin(String login) throws DAOException;

    boolean isUserByEmail(String email)throws DAOException;

    User getUserByID(long id) throws DAOException;

    User getUserByLogin(String login) throws DAOException;

    User getUserBYEmail(String email) throws DAOException;

    List<User> getAllUsers() throws DAOException;
}

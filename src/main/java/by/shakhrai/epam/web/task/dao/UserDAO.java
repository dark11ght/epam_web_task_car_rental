package by.shakhrai.epam.web.task.dao;

import by.shakhrai.epam.web.task.entity.User;
import by.shakhrai.epam.web.task.exception.DAOException;

public interface UserDAO {
    User getUserByLogin(String login) throws DAOException;
}

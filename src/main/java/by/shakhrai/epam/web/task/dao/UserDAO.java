package by.shakhrai.epam.web.task.dao;

import by.shakhrai.epam.web.task.entity.User;

public interface UserDAO {
    User getUserByLogin(String login);
}

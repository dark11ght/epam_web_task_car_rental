package by.shakhrai.epam.web.task.service;

import by.shakhrai.epam.web.task.entity.User;

public interface UserService {
    User signIn (String login, String password);
    User createUser(String login, String password, String email);
    User getUserByLogin(String login);
    User getUserByEmail(String email);
    User getUserById(long id);
    void deleteUser (User user);
}

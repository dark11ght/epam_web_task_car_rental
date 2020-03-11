package by.shakhrai.epam.web.task.service;

import by.shakhrai.epam.web.task.entity.User;
import by.shakhrai.epam.web.task.exception.UserServiceEcxeption;

import java.util.List;

public interface UserService {
    List<User> geaAllUsers() throws UserServiceEcxeption;
    User signIn(String login, String password) throws UserServiceEcxeption;
    User createUser(String login, String password, String email);
    User getUserByLogin(String login) throws UserServiceEcxeption;
    User getUserByEmail(String email);
    User getUserById(long id) throws UserServiceEcxeption;
    void deleteUser (User user);
}

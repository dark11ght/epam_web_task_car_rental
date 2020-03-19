package by.shakhrai.epam.web.task.service;

import by.shakhrai.epam.web.task.entity.User;
import by.shakhrai.epam.web.task.exception.UserServiceEcxeption;

import java.util.List;

public interface UserService {
    List<User> geaAllUsers() throws UserServiceEcxeption;
    User signIn(String login, String password) throws UserServiceEcxeption;
    void createUser(String login, String password, String first_name, String last_name, String passport_serial_number,
                    String driver_licence_number, String email, String phone_number) throws UserServiceEcxeption;
    User getUserByLogin(String login) throws UserServiceEcxeption;
    User getUserByEmail(String email);
    User getUserById(long id) throws UserServiceEcxeption;
    void deleteUser (User user);
}

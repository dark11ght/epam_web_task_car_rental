package by.shakhrai.epam.web.task.service;

import by.shakhrai.epam.web.task.entity.User;
import by.shakhrai.epam.web.task.exception.UserServiceEcxeption;

import java.util.List;

public interface UserService {
    List<User> geaAllUsers() throws UserServiceEcxeption;
    User signIn(String login, String password) throws UserServiceEcxeption;
    void createUser(String login, String password, String firstName, String lastName, String passportSerialNumber,
                    String driverLicenceNumber, String email, String phoneNumber) throws UserServiceEcxeption;
    User getUserByLogin(String login) throws UserServiceEcxeption;
    User getUserByEmail(String email);
    User getUserById(long userID) throws UserServiceEcxeption;
    void deleteUser (long userID)throws UserServiceEcxeption;
    void changePassword(long userID, String oldPassword, String newPassword, String repeatPassword)throws UserServiceEcxeption;
    void blockUser(long userID) throws UserServiceEcxeption;
    void unblockUser(long userID) throws UserServiceEcxeption;

}

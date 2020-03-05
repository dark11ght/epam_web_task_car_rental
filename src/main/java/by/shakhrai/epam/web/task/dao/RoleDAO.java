package by.shakhrai.epam.web.task.dao;

import by.shakhrai.epam.web.task.exception.DAOException;

import java.sql.SQLException;

public interface RoleDAO {
    void addUserRole(String string) throws SQLException, DAOException;
}

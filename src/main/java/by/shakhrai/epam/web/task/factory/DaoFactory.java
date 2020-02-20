package by.shakhrai.epam.web.task.factory;

import by.shakhrai.epam.web.task.dao.CarDAO;
import by.shakhrai.epam.web.task.dao.UserDAO;
import by.shakhrai.epam.web.task.dao.impl.CarDAOImpl;
import by.shakhrai.epam.web.task.dao.impl.UserDAOImpl;
import by.shakhrai.epam.web.task.databaseconnection.ConnectionPool;

public final class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private UserDAO userDAOImpl = new UserDAOImpl();
   // private CarDAO carDAOImpl = new CarDAOImpl();



    private DaoFactory() {

    }

    public static DaoFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDao(){
        return userDAOImpl;
    }


}

package by.shakhrai.epam.web.task.factory;

import by.shakhrai.epam.web.task.dao.CarDAO;
import by.shakhrai.epam.web.task.dao.OrderDAO;
import by.shakhrai.epam.web.task.dao.UserDAO;
import by.shakhrai.epam.web.task.dao.impl.CarDAOImpl;
import by.shakhrai.epam.web.task.dao.impl.OrderDAOImpl;
import by.shakhrai.epam.web.task.dao.impl.UserDAOImpl;

public enum DAOFactory {
    INSTANCE;

    private UserDAO userDAOImpl = new UserDAOImpl();
    private OrderDAO orderDAOImpl = new OrderDAOImpl();
    private CarDAO carDAOImpl = new CarDAOImpl();

    DAOFactory() {
    }


    public UserDAO getUserDao() {
        return userDAOImpl;
    }

    public CarDAO getCarDao() {
        return carDAOImpl;
    }

    public OrderDAO getOrderDao() {
        return orderDAOImpl;
    }
}

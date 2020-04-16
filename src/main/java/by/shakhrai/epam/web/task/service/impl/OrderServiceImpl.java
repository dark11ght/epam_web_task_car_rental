package by.shakhrai.epam.web.task.service.impl;

import by.shakhrai.epam.web.task.dao.CarDAO;
import by.shakhrai.epam.web.task.dao.OrderDAO;
import by.shakhrai.epam.web.task.dao.UserDAO;
import by.shakhrai.epam.web.task.entity.Car;
import by.shakhrai.epam.web.task.entity.Order;
import by.shakhrai.epam.web.task.entity.User;
import by.shakhrai.epam.web.task.exception.DAOException;
import by.shakhrai.epam.web.task.exception.OrderServiceException;
import by.shakhrai.epam.web.task.exception.UserServiceEcxeption;
import by.shakhrai.epam.web.task.factory.DAOFactory;
import by.shakhrai.epam.web.task.service.OrderService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private static final Logger LOGGER = LogManager.getLogger(OrderServiceImpl.class);
    private OrderDAO orderDAOImpl = DAOFactory.INSTANCE.getOrderDao();
    private CarDAO carDAOImpl = DAOFactory.INSTANCE.getCarDao();
    private UserDAO userDAOImpl = DAOFactory.INSTANCE.getUserDao();

    @Override
    public List<Order> getOrderByUserID(long userID) throws OrderServiceException {
        try{
            return orderDAOImpl.getOrdersByUserID(userID);
        } catch (DAOException e) {
            LOGGER.warn(e);
            throw new OrderServiceException(e);
        }
    }

    @Override
    public void createOrderByUser(long userID, int carID, int rentHours, String notes) throws OrderServiceException {
        User user;
        Car car;
        try {
            user = userDAOImpl.getUserByID(userID);
        } catch (DAOException e) {
            LOGGER.warn(e);
            throw new OrderServiceException(e);
        }
        try{
            car = carDAOImpl.getCarByID(carID);
        } catch (DAOException e) {
            LOGGER.warn(e);
            throw new OrderServiceException(e);
        }

        try{
             orderDAOImpl.createOrder(user, car, rentHours, notes);
        } catch (DAOException e) {
            LOGGER.warn(e);
            throw new OrderServiceException(e);
        }
    }

    @Override
    public Order getOrderByOrderID(long orderID) throws OrderServiceException {
        try {
            return orderDAOImpl.getOrderByOrderID(orderID);
        } catch (DAOException e) {
            LOGGER.warn(e);
            throw new OrderServiceException(e);
        }
    }
}

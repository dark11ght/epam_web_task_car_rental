package by.shakhrai.epam.web.task.service.impl;

import by.shakhrai.epam.web.task.dao.OrderDAO;
import by.shakhrai.epam.web.task.entity.Order;
import by.shakhrai.epam.web.task.exception.DAOException;
import by.shakhrai.epam.web.task.exception.UserServiceEcxeption;
import by.shakhrai.epam.web.task.factory.DAOFactory;
import by.shakhrai.epam.web.task.service.OrderService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private static final Logger LOGGER = LogManager.getLogger(OrderServiceImpl.class);
    private OrderDAO orderDAOImpl = DAOFactory.INSTANCE.getOrderDao();

    @Override
    public List<Order> getOrderByUserID(long userID) throws UserServiceEcxeption {
        try{
            return orderDAOImpl.getOrdersByUserID(userID);
        } catch (DAOException e) {
            LOGGER.warn(e);
            throw new UserServiceEcxeption(e) {
            };
        }
    }
}

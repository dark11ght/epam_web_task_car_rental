package by.shakhrai.epam.web.task.dao;

import by.shakhrai.epam.web.task.entity.Order;
import by.shakhrai.epam.web.task.exception.DAOException;

import java.util.List;

public interface OrderDAO {
    Order createOrder() throws DAOException;

    Order getOrderByOrderID(long orderID) throws DAOException;

    List<Order> getOrdersByUserID(long userID) throws DAOException;

    List<Order> getOrdersByAdminStatus() throws DAOException;

    int getUncheckOrderCount() throws DAOException;

}

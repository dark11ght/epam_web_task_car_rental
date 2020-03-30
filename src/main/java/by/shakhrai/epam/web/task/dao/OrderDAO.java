package by.shakhrai.epam.web.task.dao;

import by.shakhrai.epam.web.task.entity.Order;
import by.shakhrai.epam.web.task.exception.DAOException;

import java.util.List;

public interface OrderDAO {
    Order createOrder() throws DAOException;

    Order getOrderByOrderID(long id) throws DAOException;

    List<Order> getOrdersByUserID(long id) throws DAOException;

    List<Order> getOrdersByAdminStatus() throws DAOException;

    long getUncheckOrderCount() throws DAOException;

}

package by.shakhrai.epam.web.task.dao;

import by.shakhrai.epam.web.task.entity.Car;
import by.shakhrai.epam.web.task.entity.Order;
import by.shakhrai.epam.web.task.entity.User;
import by.shakhrai.epam.web.task.exception.DAOException;

import java.util.List;

public interface OrderDAO {
    void createOrder(User user, Car car, int rentHours, String notes) throws DAOException;
    Order getOrderByOrderID(long orderID) throws DAOException;
    List<Order> getOrdersByUserID(long userID) throws DAOException;
    List<Order> getOrdersByAdminStatus() throws DAOException;
    int getCountOrdersWhereAdminStatusFalse() throws DAOException;
    void changePaymentStatusOrderToApproved(long orderID) throws DAOException;
    void changeAdminStatusOrderToApproved(long orderID) throws DAOException;
    void changeAdminStatusOrderToBlock(long orderID) throws DAOException;
    void completeOrder(long orderID) throws DAOException;

}

package by.shakhrai.epam.web.task.service;

import by.shakhrai.epam.web.task.entity.Order;
import by.shakhrai.epam.web.task.exception.UserServiceEcxeption;

import java.util.List;

public interface OrderService {
    List<Order> getOrderByUserID(long userID) throws UserServiceEcxeption;
}

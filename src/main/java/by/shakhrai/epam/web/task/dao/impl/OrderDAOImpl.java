package by.shakhrai.epam.web.task.dao.impl;

import by.shakhrai.epam.web.task.connectionpool.ConnectionPool;
import by.shakhrai.epam.web.task.connectionpool.ConnectionProxy;
import by.shakhrai.epam.web.task.dao.OrderDAO;
import by.shakhrai.epam.web.task.entity.*;
import by.shakhrai.epam.web.task.exception.DAOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private static final Logger LOGGER = LogManager.getLogger(OrderDAO.class);
    //fields
    private static final String ORDER_ID = "id";
    private static final String USER_ID = "user_id";
    private static final String USER_LOGIN = "login";
    private static final String CAR_ID = "car_id";
    private static final String CAR_MARK = "mark";
    private static final String CAR_MODEL = "model";
    private static final String RENT_HOURS = "rent_hours";
    private static final String TOTAL_PRICE = "total_price";
    private static final String PAYMENT_STATUS = "payment_status";
    private static final String CONFIRM_STATUS = "confirm_status";
    private static final String DATE_OF_REG_ORDER = "date_of_reg_order";
    private static final String ORDER_STATUS = "order_status";
    private static final String NOTES = "notes";


    //query
    private static final String GET_ORDER_BY_ORDER_ID = "SELECT order.id, u.login, car_id, m.model, m2.mark, rent_hours,\n" +
            "       total_price, payment_status, confirm_status, date_of_reg_order, order_status, notes FROM `order`\n" +
            "       JOIN user u on `order`.user_id = u.id\n" +
            "       JOIN car c on `order`.car_id = c.id\n" +
            "       JOIN car_model m on c.model_id = m.id\n" +
            "       JOIN car_mark m2 on c.mark_id = m2.id\n" +
            " WHERE order.id = ";

    private static final String GET_ORDER_BY_USER_ID = "SELECT order.id, u.login, car_id, m.model, m2.mark, rent_hours,\n" +
            "       total_price, payment_status, confirm_status, date_of_reg_order, order_status, notes FROM `order`\n" +
            "       JOIN user u on `order`.user_id = u.id\n" +
            "       JOIN car c on `order`.car_id = c.id\n" +
            "       JOIN car_model m on c.model_id = m.id\n" +
            "       JOIN car_mark m2 on c.mark_id = m2.id\n" +
            " WHERE user_id = ";

    @Override
    public Order createOrder() throws DAOException {
        return null;
    }

    @Override
    public Order getOrderByOrderID(long orderID) throws DAOException {
        Order order = new Order();
        try (
                ConnectionProxy connection = new ConnectionProxy(ConnectionPool.INSTANCE.getConnection());
                PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_ORDER_ID + orderID);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            if (resultSet.next()) {
                User user = new User();
                Car car = new Car();
                CarModel carModel = new CarModel();
                CarMark carMark = new CarMark();
                user.setLogin(resultSet.getString(USER_LOGIN));
                order.setId(resultSet.getLong(ORDER_ID));
                order.setUser(user);
                car.setId(resultSet.getInt(CAR_ID));
                carMark.setMark(resultSet.getString(CAR_MARK));
                carModel.setModelName(resultSet.getString(CAR_MODEL));
                car.setMark(carMark);
                car.setModel(carModel);
                order.setCar(car);
                order.setRentHours(resultSet.getInt(RENT_HOURS));
                order.setTotalPrice(resultSet.getDouble(TOTAL_PRICE));
                order.setPaymentStatus(resultSet.getBoolean(PAYMENT_STATUS));
                order.setConfirmByAdminStatus(resultSet.getBoolean(CONFIRM_STATUS));
                order.setDateOfRegOrder(resultSet.getTimestamp(DATE_OF_REG_ORDER));
                order.setOrderStatus(resultSet.getBoolean(ORDER_STATUS));
                order.setNotes(resultSet.getString(NOTES));
            }
        } catch (SQLException e) {
            LOGGER.warn(e);
            throw new DAOException("Can`t get order by order ID");
        }
        return order;
    }

    @Override
    public List<Order> getOrdersByUserID(long userID) throws DAOException {
        List<Order> orders = new ArrayList<>();
        try (
                ConnectionProxy connection = new ConnectionProxy(ConnectionPool.INSTANCE.getConnection());
                PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_USER_ID + userID);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                Order order = new Order();
                User user = new User();
                Car car = new Car();
                CarModel carModel = new CarModel();
                CarMark carMark = new CarMark();
                user.setId(userID);
                user.setLogin(resultSet.getString(USER_LOGIN));
                order.setId(resultSet.getLong(ORDER_ID));
                order.setUser(user);
                car.setId(resultSet.getInt(CAR_ID));
                carMark.setMark(resultSet.getString(CAR_MARK));
                carModel.setModelName(resultSet.getString(CAR_MODEL));
                car.setMark(carMark);
                car.setModel(carModel);
                order.setCar(car);
                order.setRentHours(resultSet.getInt(RENT_HOURS));
                order.setTotalPrice(resultSet.getDouble(TOTAL_PRICE));
                order.setPaymentStatus(resultSet.getBoolean(PAYMENT_STATUS));
                order.setConfirmByAdminStatus(resultSet.getBoolean(CONFIRM_STATUS));
                order.setDateOfRegOrder(resultSet.getTimestamp(DATE_OF_REG_ORDER));
                order.setOrderStatus(resultSet.getBoolean(ORDER_STATUS));
                order.setNotes(resultSet.getString(NOTES));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.warn(e);
            throw new DAOException("Can`t get order by user ID");
        }
        return orders;
    }

    @Override
    public List<Order> getOrdersByAdminStatus() throws DAOException {
        return null;
    }

    @Override
    public int getUncheckOrderCount() throws DAOException {
        return 0;
    }
}

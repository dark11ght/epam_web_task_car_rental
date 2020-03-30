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
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private static final Logger LOGGER = LogManager.getLogger(OrderDAO.class);
    //fields
    private static final String ORDER_ID = "id";
    private static final String USER_ID = "user_id";
    private static final String CAR_ID = "car_id";
    private static final String RENT_HOURS = "rent_hours";
    private static final String TOTAL_PRICE = "total_price";
    private static final String PAYMENT_STATUS = "payment_status";
    private static final String CONFIRM_STATUS = "confirm_status";
    private static final String DATE_OF_REG_ORDER = "date_of_reg_order";
    private static final String ORDER_STATUS = "order_status";
    private static final String NOTES = "notes";



    //query
    private static final String GET_ORDER_BY_USER_ID = "SELECT order.id, u.login, m.model, m2.mark, rent_hours,\n" +
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
    public Order getOrderByOrderID(long id) throws DAOException {
        Order order = new Order();
        try(
                ConnectionProxy connection = new ConnectionProxy(ConnectionPool.INSTANCE.getConnection());
                PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_USER_ID + id);
                ResultSet resultSet = preparedStatement.executeQuery();
                ) {
            if(resultSet.next()){
                User user = new User();
                Car car = new Car();
                CarModel carModel = new CarModel();
                CarMark carMark = new CarMark();
                user.setId(resultSet.getLong(USER_ID));
                user.setLogin(resultSet.getString("login"));
                order.setUser(user);

            }
        } catch (SQLException e) {
            LOGGER.warn(e);
            throw new DAOException("Can`t get order by ID");
        }
        return order;
    }

    @Override
    public List<Order> getOrdersByUserID(long id) throws DAOException {
        return null;
    }

    @Override
    public List<Order> getOrdersByAdminStatus() throws DAOException {
        return null;
    }

    @Override
    public long getUncheckOrderCount() throws DAOException {
        return 0;
    }
}

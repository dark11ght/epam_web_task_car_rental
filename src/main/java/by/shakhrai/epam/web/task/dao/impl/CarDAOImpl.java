package by.shakhrai.epam.web.task.dao.impl;

import by.shakhrai.epam.web.task.dao.CarDAO;
import by.shakhrai.epam.web.task.connectionpool.ConnectionPool;
import by.shakhrai.epam.web.task.connectionpool.ConnectionProxy;
import by.shakhrai.epam.web.task.entity.Car;
import by.shakhrai.epam.web.task.entity.CarMark;
import by.shakhrai.epam.web.task.entity.CarModel;
import by.shakhrai.epam.web.task.entity.CarStatus;
import by.shakhrai.epam.web.task.exception.DAOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAOImpl implements CarDAO {
    private static final Logger LOGGER = LogManager.getLogger(CarDAOImpl.class);
    //fields
    private static final String CAR_ID = "id";
    private static final String CAR_MARK = "mark";
    private static final String CAR_MODEL = "model";
    private static final String CAR_MILLAGE = "millage";
    private static final String CAR_PRICE = "price";
    private static final String CAR_STATUS = "car_status";

    //query
    private static final String GET_ALL_CARS_QUERY = "SELECT car.id, m2.mark, a.model, millage, price, auto.car_status from car\n" +
            "join car_mark m2 on car.mark_id = m2.id join car_model a on\n" +
            "car.model_id = a.id join car_status auto on car.car_status_id = auto.id;";
    @Override
    public List<Car> getAllCar() throws DAOException {
        List<Car> cars = new ArrayList<>();
        try {
            try (
                    ConnectionProxy connection = new ConnectionProxy(ConnectionPool.INSTANCE.getConnection());
                    PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CARS_QUERY);
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    Car car = new Car();
                    CarMark carMark = new CarMark();
                    CarStatus carStatus = new CarStatus();
                    CarModel carModel = new CarModel();

                    car.setId(resultSet.getInt(CAR_ID));
                    carMark.setMark(resultSet.getString(CAR_MARK));
                    car.setMark(carMark);
                    carModel.setModelName(resultSet.getString(CAR_MODEL));
                    car.setModel(carModel);
                    car.setMillage(resultSet.getInt(CAR_MILLAGE));
                    car.setPrice(resultSet.getFloat(CAR_PRICE));
                    carStatus.setCarStatus(resultSet.getString(CAR_STATUS));
                    car.setCarStatus(carStatus);
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            LOGGER.warn(e);
            throw new DAOException("Can`t get cars list");
        }
        return cars;
    }
}

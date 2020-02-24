package by.shakhrai.epam.web.task.dao.impl;

import by.shakhrai.epam.web.task.dao.CarDAO;
import by.shakhrai.epam.web.task.databaseconnection.impl.ConnectionPoolUse;
import by.shakhrai.epam.web.task.entity.Car;
import by.shakhrai.epam.web.task.entity.CarMark;
import by.shakhrai.epam.web.task.entity.CarModel;
import by.shakhrai.epam.web.task.entity.CarStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAOImpl implements CarDAO {

    public CarDAOImpl() {
    }

    @Override
    public List<Car> getAllCar() {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT car.id, m2.mark, a.model, millage, price, auto.car_status from car\n" +
                "join car_mark m2 on car.mark_id = m2.id join car_model a on\n" +
                "car.model_id = a.id join car_status auto on car.car_status_id = auto.id;";
        Connection connection = ConnectionPoolUse.getConnection();
        try {
            try (
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    Car car = new Car();
                    CarMark carMark = new CarMark();
                    CarStatus carStatus = new CarStatus();
                    CarModel carModel = new CarModel();

                    car.setId(resultSet.getInt("id"));
                    carMark.setMark(resultSet.getString("mark"));
                    car.setMark(carMark);
                    carModel.setModelName(resultSet.getString("model"));
                    car.setModel(carModel);
                    car.setMillage(resultSet.getInt("millage"));
                    car.setPrice(resultSet.getFloat("price"));
                    carStatus.setCarStatus(resultSet.getString("car_status"));
                    car.setCarStatus(carStatus);
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPoolUse.releaseConnection(connection);
        }
        return cars;
    }
}

package by.shakhrai.epam.web.task.dao;

import by.shakhrai.epam.web.task.entity.Car;
import by.shakhrai.epam.web.task.exception.DAOException;

import java.util.List;

public interface CarDAO  {
    List<Car> getAllCar() throws DAOException;
    Car getCarByID(int carID) throws DAOException;
    void blockCarByOrder(int carID) throws DAOException;
    void unBlockCarByOrder(int carID) throws DAOException;

}

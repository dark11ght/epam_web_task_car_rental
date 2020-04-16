package by.shakhrai.epam.web.task.service;

import by.shakhrai.epam.web.task.entity.Car;
import by.shakhrai.epam.web.task.exception.CarServiceException;

import java.util.ArrayList;


public interface CarService {
    ArrayList<Car> getAllCars() throws CarServiceException;
    Car getCarByID(int carID)throws CarServiceException;
    void blockCarByOrder(int carID) throws CarServiceException;
    void unBlockCarByOrder(int carID) throws CarServiceException;
}

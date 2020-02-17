package by.shakhrai.epam.web.task.service.impl;

import by.shakhrai.epam.web.task.dao.CarDAO;
import by.shakhrai.epam.web.task.dao.UserDAO;
import by.shakhrai.epam.web.task.dao.impl.CarDAOImpl;
import by.shakhrai.epam.web.task.dao.impl.UserDAOImpl;
import by.shakhrai.epam.web.task.databaseconnection.ConnectionJDBC;
import by.shakhrai.epam.web.task.entity.Car;
import by.shakhrai.epam.web.task.service.CarService;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {
    private static CarServiceImpl instance;
    private ConnectionJDBC connectionJDBC;
    private CarDAO userDAO = new CarDAOImpl(connectionJDBC);


    public static CarServiceImpl getInstance(){
        if (instance == null){
            instance = new CarServiceImpl();
        }
        return instance;
    }

    @Override
    public ArrayList<Car> getAllCars() {
        List<Car> carsDAO = userDAO.getAllCar();

        return new ArrayList<>(carsDAO);
    }
}

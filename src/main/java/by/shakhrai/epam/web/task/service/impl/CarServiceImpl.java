package by.shakhrai.epam.web.task.service.impl;

import by.shakhrai.epam.web.task.dao.CarDAO;
import by.shakhrai.epam.web.task.dao.UserDAO;
import by.shakhrai.epam.web.task.entity.Car;
import by.shakhrai.epam.web.task.exception.DAOException;
import by.shakhrai.epam.web.task.factory.DaoFactory;
import by.shakhrai.epam.web.task.service.CarService;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {
    private static CarServiceImpl instance;
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private CarDAO carDAOImpl = daoFactory.getCarDao();

    public static CarServiceImpl getInstance() {
        if (instance == null) {
            instance = new CarServiceImpl();
        }
        return instance;
    }

    @Override
    public ArrayList<Car> getAllCars() {
        List<Car> carsDAO = null;
        try {
            carsDAO = carDAOImpl.getAllCar();
        } catch (DAOException e) {
            e.printStackTrace();//TODO write Exception
        }

        return new ArrayList<>(carsDAO);
    }
}

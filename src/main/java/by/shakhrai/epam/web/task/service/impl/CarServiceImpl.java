package by.shakhrai.epam.web.task.service.impl;

import by.shakhrai.epam.web.task.dao.CarDAO;
import by.shakhrai.epam.web.task.entity.Car;
import by.shakhrai.epam.web.task.exception.CarServiceException;
import by.shakhrai.epam.web.task.exception.DAOException;
import by.shakhrai.epam.web.task.factory.DAOFactory;
import by.shakhrai.epam.web.task.service.CarService;
import by.shakhrai.epam.web.task.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {
    private static final Logger LOGGER = LogManager.getLogger(CarService.class);
    private CarDAO carDAOImpl = DAOFactory.INSTANCE.getCarDao();


    @Override
    public ArrayList<Car> getAllCars() throws CarServiceException {
        List<Car> carsDAO = null;
        try {
            carsDAO = carDAOImpl.getAllCar();
        } catch (DAOException e) {
            LOGGER.warn(e);
            throw new CarServiceException(e);
        }

        return new ArrayList<>(carsDAO);
    }

    @Override
    public void blockCarByOrder(int carID) throws CarServiceException {
        try {
            carDAOImpl.blockCarByOrder(carID);
        } catch (DAOException e) {
            LOGGER.warn(e);
            throw new CarServiceException(e);
        }
    }

    @Override
    public void unBlockCarByOrder(int carID) throws CarServiceException {
        try {
            carDAOImpl.unBlockCarByOrder(carID);
        } catch (DAOException e) {
            LOGGER.warn(e);
            throw new CarServiceException(e);
        }
    }


}

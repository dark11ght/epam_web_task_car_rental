package by.shakhrai.epam.web.task.factory;

import by.shakhrai.epam.web.task.service.CarService;
import by.shakhrai.epam.web.task.service.UserService;
import by.shakhrai.epam.web.task.service.impl.CarServiceImpl;
import by.shakhrai.epam.web.task.service.impl.UserServiceImpl;

public enum ServiceFactory {
    INSTANCE;

    private UserService userServiceImpl = new UserServiceImpl();
    private CarService carServiceImpl = new CarServiceImpl();


    ServiceFactory() {
    }

    public UserService getUserService() {
        return userServiceImpl;
    }

    public CarService getCarService() {
        return carServiceImpl;
    }


}

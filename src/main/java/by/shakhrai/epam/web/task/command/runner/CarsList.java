package by.shakhrai.epam.web.task.command.runner;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.ViewParameter;
import by.shakhrai.epam.web.task.entity.Car;
import by.shakhrai.epam.web.task.factory.ServiceFactory;
import by.shakhrai.epam.web.task.service.CarService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class CarsList implements Command {
    private static final Logger LOGGER = LogManager.getLogger(CarsList.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        CarService carServiceImpl = ServiceFactory.INSTANCE.getCarService();
        HttpSession session = request.getSession();
        ArrayList<Car> cars = carServiceImpl.getAllCars();
        String userRole = (String) session.getAttribute("role");
        request.setAttribute("cars", cars);
        request.setAttribute("userRole", userRole);
        page = ViewParameter.CARS_LIST_JSP.getValue();
        return page;
    }
}

package by.shakhrai.epam.web.task.servlet.car;

import by.shakhrai.epam.web.task.entity.Car;
import by.shakhrai.epam.web.task.factory.ServiceFactory;
import by.shakhrai.epam.web.task.service.CarService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.util.ArrayList;


public class GetAllCarsServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarService carServiceImpl = ServiceFactory.INSTANCE.getCarService();
        HttpSession session = request.getSession();
        ArrayList<Car> cars = carServiceImpl.getAllCars();
        String userRole = (String) session.getAttribute("role");
        request.setAttribute("cars", cars);
        request.setAttribute("userRole", userRole);
        request.getRequestDispatcher("views/cars_list.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}

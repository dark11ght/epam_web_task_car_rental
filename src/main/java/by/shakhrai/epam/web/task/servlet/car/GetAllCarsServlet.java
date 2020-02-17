package by.shakhrai.epam.web.task.servlet.car;

        import by.shakhrai.epam.web.task.entity.Car;
        import by.shakhrai.epam.web.task.service.CarService;
        import by.shakhrai.epam.web.task.service.impl.CarServiceImpl;

        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

        import java.util.ArrayList;


public class GetAllCarsServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarService carServiceImpl = new CarServiceImpl();

        ArrayList<Car> cars = carServiceImpl.getAllCars();

        request.setAttribute("cars", cars);
        request.getRequestDispatcher("views/cars_list.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}

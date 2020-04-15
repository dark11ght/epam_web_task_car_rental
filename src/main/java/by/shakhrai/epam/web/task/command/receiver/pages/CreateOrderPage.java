package by.shakhrai.epam.web.task.command.receiver.pages;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.PageEnum;
import by.shakhrai.epam.web.task.exception.CarServiceException;
import by.shakhrai.epam.web.task.factory.ServiceFactory;
import by.shakhrai.epam.web.task.service.CarService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateOrderPage implements Command {
    private static final Logger LOGGER = LogManager.getLogger(CreateOrderPage.class);
    private CarService carServiceImpl = ServiceFactory.INSTANCE.getCarService();


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        HttpSession session = request.getSession();
        int orderCarID = Integer.parseInt(request.getParameter("orderCarID"));
        String orderCarMark = request.getParameter("orderCarMark");
        String orderCarModel = request.getParameter("orderCarModel");
        session.setAttribute("orderCarID", orderCarID);
        session.setAttribute("orderCarMark", orderCarMark);
        session.setAttribute("orderCarModel", orderCarModel);

        try {
            carServiceImpl.blockCarByOrder(orderCarID);
        } catch (CarServiceException e) {
            String message = "Can not order this car";
            request.setAttribute("informMessage", message);
            page = PageEnum.INFORMER_PAGE_JSP.getValue();
            return page;
        }

        page = PageEnum.CREATE_CAR_ORDER_PAGE.getValue();
        return page;
    }
}

package by.shakhrai.epam.web.task.command.receiver.pages;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.PageEnum;
import by.shakhrai.epam.web.task.factory.ServiceFactory;
import by.shakhrai.epam.web.task.service.CarService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateOrderPage implements Command {
    private static final Logger LOGGER = LogManager.getLogger(CreateOrderPage.class);


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        int orderCarID = Integer.parseInt(request.getParameter("orderCarID"));
        String orderCarMark = request.getParameter("orderCarMark");
        String orderCarModel = request.getParameter("orderCarModel");
        request.setAttribute("orderCarID", orderCarID);
        request.setAttribute("orderCarMark", orderCarMark);
        request.setAttribute("orderCarModel", orderCarModel);

        page = PageEnum.CREATE_CAR_ORDER_PAGE.getValue();
        return page;
    }
}

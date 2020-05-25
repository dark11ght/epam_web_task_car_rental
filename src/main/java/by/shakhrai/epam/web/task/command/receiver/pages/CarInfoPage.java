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

public class CarInfoPage implements Command {
    private static final Logger LOGGER = LogManager.getLogger(CarInfoPage.class);
    private CarService carServiceImpl = ServiceFactory.INSTANCE.getCarService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        HttpSession session = request.getSession();

        String infoCarMark = request.getParameter("infoCarMark");
        String infoCarModel = request.getParameter("infoCarModel");

        request.setAttribute("infoCarMark", infoCarMark);
        request.setAttribute("infoCarModel", infoCarModel);

        return PageEnum.CAR_INFO_PAGE.getValue();
    }
}

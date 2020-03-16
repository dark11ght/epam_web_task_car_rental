package by.shakhrai.epam.web.task.command.receiver.user;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.PageENUM;
import by.shakhrai.epam.web.task.factory.ServiceFactory;
import by.shakhrai.epam.web.task.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegistration implements Command {
    private UserService userService = ServiceFactory.INSTANCE.getUserService();
    private static final Logger LOGGER = LogManager.getLogger(UserRegistration.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;



        page = PageENUM.USER_INFO_PAGE_JSP.getValue();
        return page;
    }
}

package by.shakhrai.epam.web.task.command.receiver.user;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.PageEnum;
import by.shakhrai.epam.web.task.entity.User;
import by.shakhrai.epam.web.task.exception.UserServiceEcxeption;
import by.shakhrai.epam.web.task.factory.ServiceFactory;
import by.shakhrai.epam.web.task.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserPage implements Command {
    private static final Logger LOGGER = LogManager.getLogger(UserPage.class);
    private UserService userService = ServiceFactory.INSTANCE.getUserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        HttpSession session = request.getSession();

        if (session.getAttribute("role") != null) {
            long ActiveUserId = (long) session.getAttribute("ActiveUserId");

            try {
                User user;
                user = userService.getUserById(ActiveUserId);
                request.setAttribute("user", user);

            } catch (UserServiceEcxeption userServiceEcxeption) {
                String message = "User not found";
                request.setAttribute("informMessage", message);
                page = PageEnum.INFORMER_PAGE_JSP.getValue();
                return page;
            }

        }
        return PageEnum.USER_PAGE_JSP.getValue();
    }
}
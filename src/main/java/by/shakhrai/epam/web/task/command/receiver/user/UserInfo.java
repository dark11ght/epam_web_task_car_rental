package by.shakhrai.epam.web.task.command.receiver.user;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.PageENUM;
import by.shakhrai.epam.web.task.entity.User;
import by.shakhrai.epam.web.task.exception.UserServiceEcxeption;
import by.shakhrai.epam.web.task.factory.ServiceFactory;
import by.shakhrai.epam.web.task.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserInfo implements Command {
    private static final Logger LOGGER = LogManager.getLogger(SignIn.class);
    private UserService userService = ServiceFactory.INSTANCE.getUserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        HttpSession session = request.getSession();

        if (session.getAttribute("role") != null) {
            long userID = (long) session.getAttribute("userId");
            String userRole = (String) session.getAttribute("role");
            request.setAttribute("userRole", userRole);


            try {
                User user = new User();
                user = userService.getUserById(userID);
                request.setAttribute("user", user);

            } catch (UserServiceEcxeption userServiceEcxeption) {
                String message = "User not found";
                request.setAttribute("informMessage", message);
                page = PageENUM.INFORMER_PAGE_JSP.getValue();
                return page;
            }

        }
        return PageENUM.USER_INFO_PAGE_JSP.getValue();
    }
}
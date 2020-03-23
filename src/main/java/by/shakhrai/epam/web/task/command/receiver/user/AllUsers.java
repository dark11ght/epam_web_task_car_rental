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
import java.util.ArrayList;

public class AllUsers implements Command {
    private static final Logger LOGGER = LogManager.getLogger(AllUsers.class);
    private UserService userServiceImpl = ServiceFactory.INSTANCE.getUserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;

        HttpSession session = request.getSession();
        ArrayList<User> users = null;
        try {
            users = (ArrayList<User>) userServiceImpl.geaAllUsers();
        } catch (UserServiceEcxeption userServiceEcxeption) {
            String message = "Users not found";
            request.setAttribute("informMessage", message);
            page = PageEnum.INFORMER_PAGE_JSP.getValue();
            return page;
        }
        String userRole = (String) session.getAttribute("role");
        request.setAttribute("users", users);
        request.setAttribute("userRole", userRole);
        page = PageEnum.ALL_USER_JSP.getValue();
        return page;
    }
}

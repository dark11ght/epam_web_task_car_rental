package by.shakhrai.epam.web.task.command.receiver;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.ViewParameter;
import by.shakhrai.epam.web.task.entity.User;
import by.shakhrai.epam.web.task.exception.UserServiceEcxeption;
import by.shakhrai.epam.web.task.factory.ServiceFactory;
import by.shakhrai.epam.web.task.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class AllUsers implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        UserService userServiceImpl = ServiceFactory.INSTANCE.getUserService();
        HttpSession session = request.getSession();
        ArrayList<User> users = null;
        try {
            users = (ArrayList<User>) userServiceImpl.geaAllUsers();
        } catch (UserServiceEcxeption userServiceEcxeption) {
            String message = "Users not found";
            request.setAttribute("informMessage", message);
            page = ViewParameter.INFORMER_PAGE_JSP.getValue();
            return page;
        }
        String userRole = (String) session.getAttribute("role");
        request.setAttribute("users", users);
        request.setAttribute("userRole", userRole);
        page = ViewParameter.ALL_USER_JSP.getValue();
        return page;
    }
}

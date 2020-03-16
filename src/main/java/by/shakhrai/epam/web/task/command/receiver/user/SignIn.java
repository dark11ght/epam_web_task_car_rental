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

public class SignIn implements Command {
    private static final Logger LOGGER = LogManager.getLogger(SignIn.class);
    private UserService userService = ServiceFactory.INSTANCE.getUserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = null;
        try {
            user = userService.signIn(login, password);
        } catch (UserServiceEcxeption userServiceEcxeption) {
            String message = "Incorrect login or Password";
            request.setAttribute("informMessage", message);
            page = PageENUM.INFORMER_PAGE_JSP.getValue();
            return page;
        }

        if (user != null) {
            HttpSession session = request.getSession();
            request.setAttribute("user", user);
            if (user.getRole().getRole().equals("admin")) {
                Long userId = user.getId();
                session.setAttribute("userId", userId);
                session.setAttribute("role", user.getRole().getRole());
                String userRole = (String) session.getAttribute("role");
                request.setAttribute("userRole", userRole);
                request.setAttribute("user", user);
                page = PageENUM.ADMIN_PAGE_JSP.getValue();
            } else {
                Long id = user.getId();
                session.setAttribute("userId", id);
                request.setAttribute("user", user);
                session.setAttribute("role", user.getRole().getRole());
                page = PageENUM.USER_PAGE_JSP.getValue();
            }
        } else {
            String message = "User not found";
            request.setAttribute("informMessage", message);
            page = PageENUM.INFORMER_PAGE_JSP.getValue();
        }
        return page;
    }
}

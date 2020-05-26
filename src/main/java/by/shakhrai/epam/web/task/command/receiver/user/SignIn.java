package by.shakhrai.epam.web.task.command.receiver.user;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.PageEnum;
import by.shakhrai.epam.web.task.entity.User;
import by.shakhrai.epam.web.task.exception.OrderServiceException;
import by.shakhrai.epam.web.task.exception.UserServiceEcxeption;
import by.shakhrai.epam.web.task.factory.ServiceFactory;
import by.shakhrai.epam.web.task.service.OrderService;
import by.shakhrai.epam.web.task.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignIn implements Command {
    private static final Logger LOGGER = LogManager.getLogger(SignIn.class);
    private UserService userService = ServiceFactory.INSTANCE.getUserService();
    private OrderService orderServiceImpl = ServiceFactory.INSTANCE.getOrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "";

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = null;
        try {
            user = userService.signIn(login, password);
        } catch (UserServiceEcxeption userServiceEcxeption) {
            String message = "Incorrect login or Password";
            request.setAttribute("informMessage", message);
            page = PageEnum.INFORMER_PAGE_JSP.getValue();
            return page;
        }

        if (user != null) {
            HttpSession session = request.getSession();
            request.setAttribute("user", user);
            Long id = user.getId();
            session.setAttribute("ActiveUserId", id);
            session.setAttribute("activeUser", user);
            session.setAttribute("role", user.getRole().getRole());
            request.setAttribute("user", user);
        } else {
            String message = "User not found";
            request.setAttribute("informMessage", message);
            page = PageEnum.INFORMER_PAGE_JSP.getValue();
        }
        return page;
    }
}

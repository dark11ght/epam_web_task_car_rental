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

public class UserRegistration implements Command {
    private UserService userService = ServiceFactory.INSTANCE.getUserService();
    private static final Logger LOGGER = LogManager.getLogger(UserRegistration.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = null;
        String page;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String passportSerialNumber = request.getParameter("passportSerialNumber");
        String driverLicenceNumber = request.getParameter("driverLicenceNumber");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");

        try {
            userService.createUser(login, password, firstName, lastName, passportSerialNumber, driverLicenceNumber, email,
                    phoneNumber);
        } catch (UserServiceEcxeption userServiceEcxeption) {
            String message = "Cant create user";
            request.setAttribute("informMessage", message);
            page = PageEnum.INFORMER_PAGE_JSP.getValue();
            return page;
        }

        try {
            user = userService.getUserByLogin(login);
        } catch (UserServiceEcxeption userServiceEcxeption) {
            userServiceEcxeption.printStackTrace();
        }
        if (user != null) {
            HttpSession session = request.getSession();
            Long id = user.getId();
            session.setAttribute("userId", id);
            session.setAttribute("role", user.getRole().getRole());
            String userRole = (String) session.getAttribute("role");
            request.setAttribute("userRole", userRole);
            request.setAttribute("user", user);
            page = PageEnum.USER_PAGE_JSP.getValue();
        } else {
            String message = "User not found";
            request.setAttribute("informMessage", message);
            page = PageEnum.INFORMER_PAGE_JSP.getValue();
        }
        return page;
    }
}

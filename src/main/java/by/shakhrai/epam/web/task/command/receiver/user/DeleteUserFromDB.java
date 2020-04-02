package by.shakhrai.epam.web.task.command.receiver.user;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.PageEnum;
import by.shakhrai.epam.web.task.exception.UserServiceEcxeption;
import by.shakhrai.epam.web.task.factory.ServiceFactory;
import by.shakhrai.epam.web.task.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteUserFromDB implements Command {
    private static final Logger LOGGER = LogManager.getLogger(DeleteUserFromDB.class);
    private UserService userService = ServiceFactory.INSTANCE.getUserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        HttpSession session = request.getSession();
        long userID = Long.parseLong(request.getParameter("userID"));

        if (session.getAttribute("role") != null) {
            long ActiveUserId = (long) session.getAttribute("ActiveUserId");
            String userRole = (String) session.getAttribute("role");
            request.setAttribute("userRole", userRole);
            request.setAttribute("ActiveUserId", ActiveUserId);
        }

        if (session.getAttribute("role") != null) {
            String userRole = (String) session.getAttribute("role");
            request.setAttribute("userRole", userRole);
        }
        try {
            userService.blockUser(userID);
        } catch (UserServiceEcxeption userServiceEcxeption) {
            userServiceEcxeption.printStackTrace();
            String message = "Не удалось заблокировать пользователя";
            request.setAttribute("informMessage", message);
            page = PageEnum.INFORMER_PAGE_JSP.getValue();
            return page;
        }

        String message = "Пользователь успешно заблокирован";
        request.setAttribute("informMessage", message);
        page = PageEnum.INFORMER_PAGE_JSP.getValue();
        return page;
    }
}

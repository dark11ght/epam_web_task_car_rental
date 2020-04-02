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

public class BlockUserByUser implements Command {
    private static final Logger LOGGER = LogManager.getLogger(BlockUserByUser.class);
    private UserService userService = ServiceFactory.INSTANCE.getUserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        HttpSession session = request.getSession();
        long userID = (long) session.getAttribute("ActiveUserId");

        if (session.getAttribute("role") != null) {
            String userRole = (String) session.getAttribute("role");
            request.setAttribute("userRole", userRole);
            request.setAttribute("ActiveUserId", userID);
        }
        try {
            userService.blockUser(userID);
        } catch (UserServiceEcxeption userServiceEcxeption) {
            userServiceEcxeption.printStackTrace();
            String message = "Не удалось заблокировать пользователя ";
            request.setAttribute("informMessage", message);
            page = PageEnum.INFORMER_PAGE_JSP.getValue();
            return page;
        }


        session.invalidate();
        String message = "Пользователь успешно заблокирован";
        request.setAttribute("informMessage", message);
        page = PageEnum.INFORMER_PAGE_JSP.getValue();
        return page;
    }
}

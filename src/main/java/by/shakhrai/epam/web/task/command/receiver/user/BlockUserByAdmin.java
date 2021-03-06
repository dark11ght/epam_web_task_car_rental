package by.shakhrai.epam.web.task.command.receiver.user;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.PageEnum;
import by.shakhrai.epam.web.task.command.RoleEnum;
import by.shakhrai.epam.web.task.exception.UserServiceEcxeption;
import by.shakhrai.epam.web.task.factory.ServiceFactory;
import by.shakhrai.epam.web.task.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BlockUserByAdmin implements Command {
    private static final Logger LOGGER = LogManager.getLogger(BlockUserByAdmin.class);
    private UserService userService = ServiceFactory.INSTANCE.getUserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;

        HttpSession session = request.getSession();
        //Check role
        if(!session.getAttribute("role").equals(RoleEnum.ADMINISTRATOR.getValue())){
            return PageEnum.INDEX_JSP.getValue();
        }

        long userID = Long.parseLong(request.getParameter("userID"));
        try {
            userService.blockUser(userID);
        } catch (UserServiceEcxeption userServiceEcxeption) {
            userServiceEcxeption.printStackTrace();
            String message = "Не удалось заблокировать пользователя ";
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

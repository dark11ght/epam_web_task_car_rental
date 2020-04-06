package by.shakhrai.epam.web.task.command.receiver.pages;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.PageEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangePasswordPage implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        HttpSession session = request.getSession();
        if (session.getAttribute("role") != null) {
            long ActiveUserId = (long) session.getAttribute("ActiveUserId");
            String userRole = (String) session.getAttribute("role");
            request.setAttribute("userRole", userRole);
            request.setAttribute("ActiveUserId", ActiveUserId);
        }

        page = PageEnum.USER_CHANGE_PASSWORD_PAGE.getValue();
        return page;
    }
}

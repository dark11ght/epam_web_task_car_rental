package by.shakhrai.epam.web.task.command.receiver.pages;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.PageEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminPage implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        HttpSession session = request.getSession();
        if (session.getAttribute("role") != null) {
            String userRole = (String) session.getAttribute("role");
            request.setAttribute("userRole", userRole);
        }

        page = PageEnum.ADMIN_PAGE_JSP.getValue();
        return page;
    }
}

package by.shakhrai.epam.web.task.command.receiver.pages;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.ViewParameter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexPage implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        HttpSession session = request.getSession();
        if (session.getAttribute("role") != null) {
            String userRole = (String) session.getAttribute("role");
            request.setAttribute("userRole", userRole);
        }

        page = ViewParameter.INDEX_JSP.getValue();
        return page;
    }
}


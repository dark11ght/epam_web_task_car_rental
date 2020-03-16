package by.shakhrai.epam.web.task.command.receiver.user;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.PageENUM;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOut implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;

        HttpSession session = request.getSession();
        session.invalidate();

        page = PageENUM.INDEX_JSP.getValue();
        return page;
    }
}


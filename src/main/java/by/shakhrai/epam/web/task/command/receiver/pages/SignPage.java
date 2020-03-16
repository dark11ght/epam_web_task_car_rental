package by.shakhrai.epam.web.task.command.receiver.pages;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.PageENUM;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignPage implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return PageENUM.SIGN_PAGE_JSP.getValue();
    }
}

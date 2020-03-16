package by.shakhrai.epam.web.task.command.receiver.pages;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.ViewParameter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationPage implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return ViewParameter.REGISTRATION_PAGE.getValue();
    }
}

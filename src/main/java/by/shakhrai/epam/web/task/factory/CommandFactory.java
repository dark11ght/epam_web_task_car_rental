package by.shakhrai.epam.web.task.factory;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.CommandParameter;
import by.shakhrai.epam.web.task.command.JspParameter;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {
    public Command defineCommand(HttpServletRequest request) {
        return CommandParameter.valueOf(request.getParameter(JspParameter.COMMAND.getValue())).getCommand();
    }
}

package by.shakhrai.epam.web.task.factory;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.CommandParameter;
import by.shakhrai.epam.web.task.command.JSPParameter;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {
    public Command defineCommand(HttpServletRequest request) {
        return CommandParameter.valueOf(request.getParameter(JSPParameter.COMMAND.getValue())).getCommand();
    }
}

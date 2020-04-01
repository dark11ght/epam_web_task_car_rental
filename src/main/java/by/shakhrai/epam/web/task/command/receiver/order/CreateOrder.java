package by.shakhrai.epam.web.task.command.receiver.order;

import by.shakhrai.epam.web.task.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateOrder implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}

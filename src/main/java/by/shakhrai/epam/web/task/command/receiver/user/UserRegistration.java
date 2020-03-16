package by.shakhrai.epam.web.task.command.receiver.user;

import by.shakhrai.epam.web.task.command.Command;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegistration implements Command {
    private static final Logger LOGGER = LogManager.getLogger(UserRegistration.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {


        return null;
    }
}

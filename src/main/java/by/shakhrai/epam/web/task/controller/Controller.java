package by.shakhrai.epam.web.task.controller;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.PageEnum;
import by.shakhrai.epam.web.task.connectionpool.ConnectionPool;
import by.shakhrai.epam.web.task.factory.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    private static final CommandFactory COMMAND_FACTORY = new CommandFactory();

    @Override
    public void init() {
        ConnectionPool.INSTANCE.initPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Command command = COMMAND_FACTORY.defineCommand(request);
        String path = command.execute(request, response);
        if (path != null) {
            request.getRequestDispatcher(path).forward(request, response);
        }else {
            request.getRequestDispatcher(PageEnum.INDEX_JSP.getValue()).forward(request, response);
        }
    }
}

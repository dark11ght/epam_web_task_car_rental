package by.shakhrai.epam.web.task.filter;

import by.shakhrai.epam.web.task.command.CommandParameter;
import by.shakhrai.epam.web.task.command.JSPParameter;
import by.shakhrai.epam.web.task.command.ViewParameter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CommandFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String command = request.getParameter(JSPParameter.COMMAND.getValue());
        if (command != null && !command.isEmpty()) {
            try {
                CommandParameter.valueOf(command.toUpperCase());
            } catch (IllegalArgumentException e) {
                resp.sendRedirect(req.getContextPath() + ViewParameter.INDEX_JSP.getValue());
                return;
            }
        } else {
            resp.sendRedirect(req.getContextPath() + ViewParameter.INDEX_JSP.getValue());
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}



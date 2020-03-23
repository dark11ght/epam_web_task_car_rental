package by.shakhrai.epam.web.task.filter;

import by.shakhrai.epam.web.task.command.CommandParameter;

import javax.servlet.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class PageSecurityFilter implements Filter {
    private static final String COMMAND_PARAMETER = "/?command=";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + COMMAND_PARAMETER + CommandParameter.ERROR_PAGE);
    }

    @Override
    public void destroy() {

    }

}



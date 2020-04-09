package by.shakhrai.epam.web.task.filter;

import by.shakhrai.epam.web.task.command.LocaleType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

@WebFilter(urlPatterns = {"/*"}, initParams = {@WebInitParam(name = "locale", value = "EN")})
public class LocaleFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(LocaleFilter.class);
    private LocaleType defaultLocale;

    @Override
    public void init(FilterConfig filterConfig) {
        defaultLocale = LocaleType.valueOf(filterConfig.getInitParameter("locale"));
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        setLocale(httpRequest, httpResponse);
        chain.doFilter(httpRequest, httpResponse);
    }

    private void setLocale(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        LocaleType type;
        String locale;
        if (session.getAttribute("userLocale") != null) {
            type = (LocaleType) session.getAttribute("userLocale");
        } else {
            type = defaultLocale;
            session.setAttribute("userLocale", type);
        }
        LOGGER.warn(type.getCountry() + " " + type.getLanguage());
        response.setLocale(new Locale(type.getLanguage(), type.getCountry()));
    }


    @Override
    public void destroy() {

    }
}

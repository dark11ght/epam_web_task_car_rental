package by.shakhrai.epam.web.task.filter;

import by.shakhrai.epam.web.task.command.CookieName;
import by.shakhrai.epam.web.task.command.LocaleType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.Cookie;
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
        Cookie[] cookies = request.getCookies();
        LocaleType type;
        String locale;
        if (cookies != null && !(locale = findCookie(cookies, CookieName.LOCALE.toString())).isEmpty()) {
            type = LocaleType.valueOf(locale.toUpperCase());
        } else {
            type = defaultLocale;
            setCookie(response);
        }
        LOGGER.warn(type.getCountry() + " " + type.getLanguage());
        response.setLocale(new Locale(type.getLanguage(), type.getCountry()));
    }

    private void setCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie(CookieName.LOCALE.toString(), defaultLocale.toString());
        response.addCookie(cookie);
    }

    private String findCookie(Cookie[] cookies, String name) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return cookie.getValue();
            }
        }
        return new String();
    }


    @Override
    public void destroy() {

    }
}

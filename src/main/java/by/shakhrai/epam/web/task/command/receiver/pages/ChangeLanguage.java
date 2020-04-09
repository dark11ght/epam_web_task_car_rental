package by.shakhrai.epam.web.task.command.receiver.pages;

import by.shakhrai.epam.web.task.command.Command;

import by.shakhrai.epam.web.task.command.JspParameter;
import by.shakhrai.epam.web.task.command.LocaleType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Locale;

public class ChangeLanguage implements Command {
    private static final Logger LOGGER = LogManager.getLogger(ChangeLanguage.class);



    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        if (session.getAttribute("role") != null) {
            long ActiveUserId = (long) session.getAttribute("ActiveUserId");
            String userRole = (String) session.getAttribute("role");
            request.setAttribute("userRole", userRole);
            request.setAttribute("ActiveUserId", ActiveUserId);
        }

        String language = request.getParameter(JspParameter.LANGUAGE.getValue());
        LOGGER.warn(language);
        LocaleType localeType = LocaleType.valueOf(language);
        session.setAttribute("userLocale", localeType);
        response.setLocale(new Locale(localeType.getLanguage(), localeType.getCountry()));
        LOGGER.warn(response.getLocale().getLanguage() + " " + response.getLocale().getCountry());
        return new IndexPage().execute(request, response);
    }


}

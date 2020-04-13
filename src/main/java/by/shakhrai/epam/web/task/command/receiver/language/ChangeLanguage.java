package by.shakhrai.epam.web.task.command.receiver.language;

import by.shakhrai.epam.web.task.command.Command;

import by.shakhrai.epam.web.task.command.JspParameter;
import by.shakhrai.epam.web.task.command.receiver.pages.IndexPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        Language localeType = Language.valueOf(language);
        String languageType = localeType.getLanguage();
        session.setAttribute("language", languageType);
        return new IndexPage().execute(request, response);
    }


}

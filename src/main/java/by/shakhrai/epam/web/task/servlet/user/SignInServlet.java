package by.shakhrai.epam.web.task.servlet.user;

import by.shakhrai.epam.web.task.entity.User;
import by.shakhrai.epam.web.task.service.UserService;
import by.shakhrai.epam.web.task.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = userService.signIn(login, password);
        if (user != null) {
            request.setAttribute("user", user);
            if (user.getRole().getRole().equals("admin")) {
                Long userId = user.getId();
                session.setAttribute("id", userId);
                request.setAttribute("user", user);
                request.getRequestDispatcher("views/admin_page.jsp").forward(request, response);
            } else {
                Long id = user.getId();
                session.setAttribute("id", id);
                request.setAttribute("user", user);
                request.getRequestDispatcher("views/user_page.jsp").forward(request, response);
            }

        } else {

            String message = "User not found";
            request.setAttribute("informMessage", message);
            request.getRequestDispatcher("views/informer.jsp").forward(request, response);
        }

    }
}

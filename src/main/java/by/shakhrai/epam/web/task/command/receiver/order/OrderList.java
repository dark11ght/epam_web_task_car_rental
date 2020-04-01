package by.shakhrai.epam.web.task.command.receiver.order;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.PageEnum;
import by.shakhrai.epam.web.task.entity.Order;
import by.shakhrai.epam.web.task.exception.UserServiceEcxeption;
import by.shakhrai.epam.web.task.factory.ServiceFactory;
import by.shakhrai.epam.web.task.service.OrderService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class OrderList implements Command {
    private static final Logger LOGGER = LogManager.getLogger(OrderList.class);
    private OrderService orderServiceImpl = ServiceFactory.INSTANCE.getOrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        HttpSession session = request.getSession();
        long userID = (long) session.getAttribute("userId");
        List<Order> orders = null;
        try {
            orders = orderServiceImpl.getOrderByUserID(userID);
        } catch (UserServiceEcxeption userServiceEcxeption) {
            String message = "Orders not found";
            request.setAttribute("informMessage", message);
            page = PageEnum.INFORMER_PAGE_JSP.getValue();
            return page;
        }

        System.out.println(orders);
        String userRole = (String) session.getAttribute("role");
        request.setAttribute("orders", orders);
        request.setAttribute("userRole", userRole);
        page = PageEnum.ORDER_PAGE.getValue();
        return page;
    }
}

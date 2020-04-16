package by.shakhrai.epam.web.task.command.receiver.order;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.PageEnum;
import by.shakhrai.epam.web.task.entity.Order;
import by.shakhrai.epam.web.task.exception.OrderServiceException;
import by.shakhrai.epam.web.task.factory.ServiceFactory;
import by.shakhrai.epam.web.task.service.OrderService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class OrderByConfirmStatus implements Command {
    private static final Logger LOGGER = LogManager.getLogger(OrderByConfirmStatus.class);
    private OrderService orderServiceImpl = ServiceFactory.INSTANCE.getOrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        List<Order> orders = null;
        try {
            orders = orderServiceImpl.getOrderByConfirmStatus();
        } catch (OrderServiceException e) {
            String message = "Orders not found";
            request.setAttribute("informMessage", message);
            page = PageEnum.INFORMER_PAGE_JSP.getValue();
            return page;
        }

        request.setAttribute("orders", orders);
        page = PageEnum.ORDERS_PAGE.getValue();
        return page;
    }
}

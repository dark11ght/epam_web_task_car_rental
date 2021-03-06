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

public class PaymentOrder implements Command {
    private static final Logger LOGGER = LogManager.getLogger(PaymentOrder.class);
    private OrderService orderServiceImpl = ServiceFactory.INSTANCE.getOrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        Order order;
        long orderID = Long.parseLong(request.getParameter("paymentOrderID"));
        float totalCost = Float.parseFloat(request.getParameter("totalCost"));

        try {
            orderServiceImpl.paymentOrder(orderID, totalCost);
        } catch (OrderServiceException e) {
            String message = "Total cost and enter cost do not much";
            request.setAttribute("informMessage", message);
            page = PageEnum.INFORMER_PAGE_JSP.getValue();
            return page;
        }

        try {
            order = orderServiceImpl.getOrderByOrderID(orderID);
        } catch (OrderServiceException e) {
            String message = "Order is not found";
            request.setAttribute("informMessage", message);
            page = PageEnum.INFORMER_PAGE_JSP.getValue();
            return page;
        }

        request.setAttribute("order", order);

        page = PageEnum.ORDER_INFO_PAGE.getValue();
        return page;
    }
}

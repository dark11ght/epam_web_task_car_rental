package by.shakhrai.epam.web.task.command.receiver.pages;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.PageEnum;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaymentOrderPage implements Command {
    private static final Logger LOGGER = LogManager.getLogger(CreateOrderPage.class);


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        long paymentOrderID = Long.parseLong(request.getParameter("paymentOrderID"));
        float totalPrice = Float.parseFloat(request.getParameter("totalPrice"));
        request.setAttribute("paymentOrderID", paymentOrderID);
        request.setAttribute("totalPrice", totalPrice);

        page = PageEnum.PAYMENT_ORDER_PAGE.getValue();
        return page;
    }
}

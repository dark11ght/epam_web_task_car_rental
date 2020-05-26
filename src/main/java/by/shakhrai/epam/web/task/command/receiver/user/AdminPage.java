package by.shakhrai.epam.web.task.command.receiver.user;

import by.shakhrai.epam.web.task.command.Command;
import by.shakhrai.epam.web.task.command.PageEnum;
import by.shakhrai.epam.web.task.command.RoleEnum;
import by.shakhrai.epam.web.task.exception.OrderServiceException;
import by.shakhrai.epam.web.task.factory.ServiceFactory;
import by.shakhrai.epam.web.task.service.OrderService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminPage implements Command {
    private static final Logger LOGGER = LogManager.getLogger(AdminPage.class);
    private OrderService orderServiceImpl = ServiceFactory.INSTANCE.getOrderService();


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        //Check role
        if(!session.getAttribute("role").equals(RoleEnum.ADMINISTRATOR.getValue())){
            return PageEnum.INDEX_JSP.getValue();
        }

        int countOrdersWhereAdminStatusFalse = 0;

        try {
            countOrdersWhereAdminStatusFalse = orderServiceImpl.getCountOrdersWhereAdminStatusFalse();
        } catch (OrderServiceException e) {
            e.printStackTrace();
        }
        request.setAttribute("countOrder", countOrdersWhereAdminStatusFalse);

        return PageEnum.ADMIN_PAGE_JSP.getValue();
    }
}

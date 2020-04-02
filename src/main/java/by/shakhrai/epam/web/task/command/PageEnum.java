package by.shakhrai.epam.web.task.command;

public enum PageEnum {
    REGISTRATION_PAGE("views/registration_page.jsp"),
    ALL_USER_JSP("views/users_page.jsp"),
    INDEX_JSP("views/index.jsp"),
    SIGN_PAGE_JSP("views/sign_page.jsp"),
    INFORMER_PAGE_JSP("views/informer.jsp"),
    CARS_LIST_JSP("views/cars_list.jsp"),
    PAGE_404_JSP("views/404.jsp"),
    ADMIN_PAGE_JSP("views/admin_page.jsp"),
    ERROR_PAGE_JSP("views/error_page.jsp"),
    USER_PAGE_JSP("views/user_page.jsp"),
    ORDER_PAGE("views/orders.jsp");


    private String value;

    private PageEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

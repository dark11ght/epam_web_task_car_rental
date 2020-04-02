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
    USER_INFO_PAGE_BY_ADMIN_JSP("views/user_info_page_by_admin.jsp"),
    ORDER_PAGE("views/orders.jsp"),
    USER_CHANGE_PASSWORD_PAGE("views/user_change_password_page.jsp");


    private String value;

    private PageEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

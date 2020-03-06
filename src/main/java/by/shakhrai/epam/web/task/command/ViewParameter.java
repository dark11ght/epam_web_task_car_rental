package by.shakhrai.epam.web.task.command;

public enum ViewParameter {
    INDEX_JSP("views/index.jsp"),
    SIGN_PAGE_JSP("views/sign_page.jsp"),
    INFORMER_PAGE_JSP("views/informer.jsp"),
    CARS_LIST_JSP("views/cars_list.jsp"),
    PAGE_404_JSP("views/404.jsp"),
    ADMIN_PAGE_JSP("views/admin_page.jsp"),
    ERROR_PAGE_JSP("views/error_page.jsp"),
    USER_INFO_PAGE_JSP("user_info_page.jsp"),
    USER_PAGE_JSP("user_page.jsp");


    private String value;

    private ViewParameter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

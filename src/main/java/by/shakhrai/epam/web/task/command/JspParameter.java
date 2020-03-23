package by.shakhrai.epam.web.task.command;

public enum JspParameter {
    COMMAND("command"),
    HREF("href"),
    ;

    private String value;

    private JspParameter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

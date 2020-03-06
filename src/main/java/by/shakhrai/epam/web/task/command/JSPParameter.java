package by.shakhrai.epam.web.task.command;

public enum JSPParameter {
    COMMAND("command");

    private String value;

    private JSPParameter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

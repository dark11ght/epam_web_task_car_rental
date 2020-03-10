package by.shakhrai.epam.web.task.exception;

public class UserServiceEcxeption extends Exception {
    public UserServiceEcxeption() {
    }

    public UserServiceEcxeption(String message) {
        super(message);
    }

    public UserServiceEcxeption(String message, Throwable cause) {
        super(message, cause);
    }

    public UserServiceEcxeption(Throwable cause) {
        super(cause);
    }

    public UserServiceEcxeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

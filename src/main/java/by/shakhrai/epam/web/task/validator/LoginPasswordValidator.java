package by.shakhrai.epam.web.task.validator;

public class LoginPasswordValidator {
    private static final String LOGIN_PASS_PATTERN = "^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$";


    public static boolean validatoinLogin(String login) {
        if (!login.matches(LOGIN_PASS_PATTERN)) {
            return false;
        }
        return true;
    }


    public static boolean validatoinPassword(String password) {
        if (!password.matches(LOGIN_PASS_PATTERN)) {
            return false;
        }
        return true;
    }

}

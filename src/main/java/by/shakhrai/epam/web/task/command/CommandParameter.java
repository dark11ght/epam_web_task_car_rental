package by.shakhrai.epam.web.task.command;

import by.shakhrai.epam.web.task.command.receiver.car.CarsList;
import by.shakhrai.epam.web.task.command.receiver.pages.AdminPage;
import by.shakhrai.epam.web.task.command.receiver.pages.IndexPage;
import by.shakhrai.epam.web.task.command.receiver.pages.RegistrationPage;
import by.shakhrai.epam.web.task.command.receiver.pages.SignPage;
import by.shakhrai.epam.web.task.command.receiver.user.AllUsers;
import by.shakhrai.epam.web.task.command.receiver.user.LogOut;
import by.shakhrai.epam.web.task.command.receiver.user.SignIn;
import by.shakhrai.epam.web.task.command.receiver.user.UserRegistration;

public enum CommandParameter {
    USER_REGISTRATION_PAGE {
        {
            this.command = new RegistrationPage();
        }
    },


    USER_REGISTRATION {
        {
            this.command = new UserRegistration();
        }
    },

    SIGN_IN_PAGE {
        {
            this.command = new SignPage();
        }
    },

    SIGN_IN {
        {
            this.command = new SignIn();
        }
    },

    ALL_USER_LIST {
        {
            this.command = new AllUsers();
        }
    },


    ADMIN_PAGE {
        {
            this.command = new AdminPage();
        }
    },


    INDEX_PAGE {
        {
            this.command = new IndexPage();
        }
    },
    CARS_LIST {
        {
            this.command = new CarsList();
        }
    },

    LOGOUT {
        {
            this.command = new LogOut();
        }
    },

    ;

    Command command;

    public Command getCommand() {
        return command;
    }
}

package by.shakhrai.epam.web.task.command;

import by.shakhrai.epam.web.task.command.receiver.car.CarsList;
import by.shakhrai.epam.web.task.command.receiver.order.OrderList;
import by.shakhrai.epam.web.task.command.receiver.pages.*;
import by.shakhrai.epam.web.task.command.receiver.user.*;

public enum CommandParameter {
    USER_REGISTRATION_PAGE {
        {
            this.command = new RegistrationPage();
        }
    },

    USER_INFO_PAGE {
        {
            this.command = new UserInfo();
        }
    },

    ERROR_PAGE {
        {
            this.command = new ErrorPage();
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

    USER_PAGE {
        {
            this.command = new UserPage();
        }
    },//TODO delete


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

    ORDERS_BY_USER_ID{
        {
            this.command = new OrderList();
        }
    },

    LOGOUT {
        {
            this.command = new LogOut();
        }
    };

    Command command;

    public Command getCommand() {
        return command;
    }
}

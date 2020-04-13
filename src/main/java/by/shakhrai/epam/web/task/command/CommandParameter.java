package by.shakhrai.epam.web.task.command;

import by.shakhrai.epam.web.task.command.receiver.car.CarsList;
import by.shakhrai.epam.web.task.command.receiver.language.ChangeLanguage;
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
            this.command = new UserPage();
        }
    },

    CHANGE_LANGUAGE {
        {
            this.command = new ChangeLanguage();
        }
    },

    USER_INFO_PAGE_BY_ADMIN {
        {
            this.command = new UserInfoPageByAdmin();
        }
    },

    USER_CHANGE_PASSWORD_PAGE {
        {
            this.command = new ChangePasswordPage();
        }
    },

    USER_CHANGE_PASSWORD {
        {
            this.command = new ChangePassword();
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

    ORDERS_BY_USER_ID {
        {
            this.command = new OrderList();
        }
    },

    LOGOUT {
        {
            this.command = new LogOut();
        }
    },
    UNBLOCK_USER {
        {
            this.command = new UnblockUser();
        }
    },
    BLOCK_USER_BY_ADMIN {
        {
            this.command = new BlockUserByAdmin();
        }
    },
    BLOCK_USER {
        {
            this.command = new BlockUserByUser();
        }
    },
    DELETE_USER_FROM_DB {
        {
            this.command = new DeleteUserFromDB();
        }
    },


    ;

    Command command;

    public Command getCommand() {
        return command;
    }
}

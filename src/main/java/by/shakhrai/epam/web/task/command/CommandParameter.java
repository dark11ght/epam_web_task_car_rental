package by.shakhrai.epam.web.task.command;

import by.shakhrai.epam.web.task.command.receiver.*;

public enum CommandParameter {
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
            this.command = new Index();
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

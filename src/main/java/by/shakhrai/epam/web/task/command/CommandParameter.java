package by.shakhrai.epam.web.task.command;

import by.shakhrai.epam.web.task.command.runner.*;

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

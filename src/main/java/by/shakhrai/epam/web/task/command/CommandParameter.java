package by.shakhrai.epam.web.task.command;

import by.shakhrai.epam.web.task.command.runner.Index;
import by.shakhrai.epam.web.task.command.runner.LogOut;
import by.shakhrai.epam.web.task.command.runner.SignIn;

public enum CommandParameter {
    SIGN_IN {
        {
            this.command = new SignIn();
        }

    },

    INDEX {
        {
            this.command = new Index();
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

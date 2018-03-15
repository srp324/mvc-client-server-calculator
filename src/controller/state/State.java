package controller.state;

import controller.Command;
import controller.Controller;

public interface State {
    void handle(Controller context);


    default boolean isDigit(Command comm) {
        return (comm == Command.ONE ||
                comm == Command.TWO ||
                comm == Command.THREE ||
                comm == Command.FOUR ||
                comm == Command.FIVE ||
                comm == Command.SIX ||
                comm == Command.SEVEN ||
                comm == Command.EIGHT ||
                comm == Command.NINE ||
                comm == Command.ZERO
        );
    }
}

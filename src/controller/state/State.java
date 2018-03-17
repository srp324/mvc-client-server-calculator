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

    default boolean isOp(Command comm) {
        return (comm == Command.ADD ||
                comm == Command.SUB ||
                comm == Command.MULT ||
                comm == Command.DIV
        );
    }

    default boolean isEquals(Command comm) {
        return comm == Command.EQ;
    }

    default boolean isClear(Command comm) {
        return comm == Command.CLEAR;
    }
}

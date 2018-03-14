package model;

import controller.State;
import controller.Command;

public class CalcList {
    public String equation = "";
    public String full;
    public Integer lhs;
    public Integer rhs;

    public State state;

    CalcList() {
        state = State.START;
        equation = "";
        full = "";
    }

    // TODO: How do I follow the state pattern for this?
    public void transition(Command comm) {
        if (state == State.START) {
            if (isDigit(comm)) {
                equation = equation + comm.getValue();
                state = State.FIRSTOP;
            }
            else if (comm == Command.ADD)
                state = State.ERROR;
        }
        else if (state == State.FIRSTOP) {
            if (isDigit(comm)) {
                equation = equation + comm.getValue();
            }
            else if (comm == Command.ADD) {
                lhs = Integer.parseInt(equation);
                equation = "";
                state = State.NEXTOP;
            }
        }
        else if (state == State.NEXTOP) {
            if (isDigit(comm)) {
                equation = comm.getValue();
                state = State.SECONDOP;
            }
            else if (comm == Command.ADD)
                state = State.ERROR;
        }
        else if (state == State.SECONDOP) {
            if (isDigit(comm))
                equation = equation + comm.getValue();
            else if (comm == Command.ADD) {
                rhs = Integer.parseInt(equation);
                equation = Integer.toString(lhs + rhs);
                lhs = Integer.parseInt(equation);
                state = State.NEXTOP;
            }
        }

        if (state == State.ERROR)
            equation = "error";
    }

    private boolean isDigit(Command comm) {
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

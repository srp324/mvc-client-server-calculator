package model;

import controller.States;
import controller.Command;

public class CalcList {
    public String equation = "";
    public String full;
    public Integer lhs;
    public Integer rhs;

    //TODO: Remove when controller states are implemented
    public States states;

    CalcList() {
        states = States.START;
        equation = "";
        full = "";
    }

    public void transition(Command comm) {
        if (states == States.START) {
            if (isDigit(comm)) {
                equation = equation + comm.getValue();
                states = States.FIRSTOP;
            }
            else if (comm == Command.ADD)
                states = States.ERROR;
        }
        else if (states == States.FIRSTOP) {
            if (isDigit(comm)) {
                equation = equation + comm.getValue();
            }
            else if (comm == Command.ADD) {
                lhs = Integer.parseInt(equation);
                equation = "";
                states = States.NEXTOP;
            }
        }
        else if (states == States.NEXTOP) {
            if (isDigit(comm)) {
                equation = comm.getValue();
                states = States.SECONDOP;
            }
            else if (comm == Command.ADD)
                states = States.ERROR;
        }
        else if (states == States.SECONDOP) {
            if (isDigit(comm))
                equation = equation + comm.getValue();
            else if (comm == Command.ADD) {
                rhs = Integer.parseInt(equation);
                equation = Integer.toString(lhs + rhs);
                lhs = Integer.parseInt(equation);
                states = States.NEXTOP;
            }
        }

        if (states == States.ERROR)
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

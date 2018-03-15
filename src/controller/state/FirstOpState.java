package controller.state;

import controller.Command;
import controller.Controller;

public class FirstOpState implements State {
    @Override
    public void handle(Controller context) {
        if (isDigit(context.getCommand())) {
            context.getModel().equation += context.getCommand().getValue();
        }
        else if (context.getCommand() == Command.ADD) {
            context.getModel().lhs = Integer.parseInt(context.getModel().equation);
            context.getModel().equation = "";
            context.setState(new NextOpState());
        }
    }

    /*
    if (isDigit(comm)) {
                equation = equation + comm.getValue();
            }
            else if (comm == Command.ADD) {
                lhs = Integer.parseInt(equation);
                equation = "";
                states = States.NEXTOP;
            }
     */
}

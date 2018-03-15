package controller.state;

import controller.Command;
import controller.Controller;

public class SecondOpState implements State {
    @Override
    public void handle(Controller context) {
        if (isDigit(context.getCommand())) {
            context.getModel().equation += context.getCommand().getValue();
        }
        else if (context.getCommand() == Command.ADD) {
            context.getModel().rhs = Integer.parseInt(context.getModel().equation);
            context.getModel().equation = Integer.toString(context.getModel().lhs + context.getModel().rhs);
            context.getModel().lhs = Integer.parseInt(context.getModel().equation);
            context.setState(new NextOpState());
        }
    }

    /*
    if (isDigit(comm))
                equation = equation + comm.getValue();
            else if (comm == Command.ADD) {
                rhs = Integer.parseInt(equation);
                equation = Integer.toString(lhs + rhs);
                lhs = Integer.parseInt(equation);
                states = States.NEXTOP;
            }
     */
}

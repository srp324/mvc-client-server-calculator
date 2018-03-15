package controller.state;

import controller.Command;
import controller.Controller;

public class StartState implements State {
    @Override
    public void handle(Controller context) {
        if (isDigit(context.getCommand())) {
            context.getModel().equation += context.getCommand().getValue();
            context.setState(new FirstOpState());
        }
        else if (context.getCommand() == Command.ADD)
            context.setState(new ErrorState());
    }

    /*
    if (isDigit(comm)) {
                equation = equation + comm.getValue();
                states = States.FIRSTOP;
            }
            else if (comm == Command.ADD)
                states = States.ERROR;
     */
}

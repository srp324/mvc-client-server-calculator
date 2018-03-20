package controller.state;

import controller.Controller;

public class CalcState implements State {
    @Override
    public void handle(Controller context) {
        if (isDigit(context.getCommand())) { //C8
            context.getModel().setEquation(context.getCommand().getValue());
            context.setState(new FirstOpState());
        }
        else { //C9
            context.getModel().setLhs(null);
            context.getModel().setRhs(null);
            context.getModel().setEquation("");
            context.getModel().clearNodes();
            context.setState(new StartState());
        }

    }
}

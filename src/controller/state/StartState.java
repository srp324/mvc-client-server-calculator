package controller.state;

import controller.Controller;

public class StartState implements State {
    @Override
    public void handle(Controller context) {
        if (isDigit(context.getCommand())) {
            context.getModel().setEquation(context.getModel().getEquation() + context.getCommand().getValue());
            context.setState(new FirstOpState());
        }
    }
}

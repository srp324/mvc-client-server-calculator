package controller.state;

import controller.Controller;

public class CalcState implements State {
    @Override
    public void handle(Controller context) {
        if (isDigit(context.getCommand())) { //C8
            context.getModel().equation = context.getCommand().getValue();
            context.getModel().full += context.getCommand().getValue();
            context.setState(new FirstOpState());
        }
        else { //C9
            context.getModel().lhs = null;
            context.getModel().rhs = null;
            context.getModel().equation = "";
            context.getModel().full = "";
            context.getModel().clearNodes();
            context.setState(new StartState());
        }

    }
}

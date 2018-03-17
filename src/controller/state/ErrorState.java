package controller.state;

import controller.Controller;

public class ErrorState implements State {
    @Override
    public void handle(Controller context) {
        if (context.getCommand().getValue().equals("Discard")) {
            if (context.getModel().onError.endsWith("F"))
                context.setState(new FirstOpState());
            else
                context.setState(new NextOpState());
            context.getModel().equation = context.getModel().onError.substring(0, context.getModel().onError.length()-1);
        }
        else if (context.getCommand().getValue().equals("Reset")) {
            context.getModel().lhs = null;
            context.getModel().rhs = null;
            context.getModel().equation = "";
            context.getModel().full = "";
            context.getModel().clearNodes();
            context.setState(new StartState());
        }
    }
}

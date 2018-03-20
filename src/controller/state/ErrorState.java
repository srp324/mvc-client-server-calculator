package controller.state;

import controller.Controller;

public class ErrorState implements State {
    @Override
    public void handle(Controller context) {
        if (context.getCommand().getValue().equals("Discard")) {
            if (context.getModel().getOnError().endsWith("F"))
                context.setState(new FirstOpState());
            else
                context.setState(new NextOpState());
            context.getModel().setEquation(context.getModel().getOnError().substring(0, context.getModel().getOnError().length()-1));
        }
        else if (context.getCommand().getValue().equals("Reset")) {
            context.getModel().setLhs(null);
            context.getModel().setRhs(null);
            context.getModel().setEquation("");
            context.getModel().clearNodes();
            context.setState(new StartState());
        }
    }
}

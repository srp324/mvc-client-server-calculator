package controller.state;

import controller.Controller;

public class FirstOpState implements State {
    @Override
    public void handle(Controller context) {
        if (isDigit(context.getCommand())) {
            context.getModel().setEquation(context.getModel().getEquation() + context.getCommand().getValue());
        }
        else if (isOp(context.getCommand())) {
            context.getModel().addNode(context.getCommand().getValue(), context.getModel().getEquation(), true); //Left leaf

            context.getModel().setCurrOp(context.getCommand().getValue());

            context.getModel().setLhs(Integer.parseInt(context.getModel().getEquation()));
            context.getModel().setEquation("");
            context.setState(new NextOpState());
        }
        else if (isEquals(context.getCommand())) {
            context.getModel().setOnError(context.getModel().getEquation() + "F");
            context.getModel().setEquation("error");
            context.setState(new ErrorState());
        }
        else if (isClear(context.getCommand())) {
            context.getModel().setLhs(null);
            context.getModel().setRhs(null);
            context.getModel().setEquation("");
            context.getModel().clearNodes();
            context.setState(new StartState());
        }
    }
}

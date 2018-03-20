package controller.state;

import controller.Controller;

public class NextOpState implements State {
    @Override
    public void handle(Controller context) {
        if (isDigit(context.getCommand())) {

            context.getModel().setEquation(context.getCommand().getValue());

            context.getModel().addRightLeaf(context.getModel().getEquation()); //Right leaf

            context.setState(new SecondOpState());
        }
        else if (isOp(context.getCommand()) || isEquals(context.getCommand())) {
            context.getModel().setOnError(context.getModel().getEquation() + "N");
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

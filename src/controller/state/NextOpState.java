package controller.state;

import controller.Controller;

public class NextOpState implements State {
    @Override
    public void handle(Controller context) {
        if (isDigit(context.getCommand())) {

            context.getModel().equation = context.getCommand().getValue();
            context.getModel().full += context.getCommand().getValue();

            context.getModel().addRightLeaf(context.getModel().equation); //Right leaf

            context.setState(new SecondOpState());
        }
        else if (isOp(context.getCommand()) || isEquals(context.getCommand())) {
            //TODO: Discard/Reset
            context.getModel().lhs = null;
            context.getModel().rhs = null;
            context.getModel().equation = "error";
            context.getModel().full = "";
            context.setState(new ErrorState());
        }
        else if (isClear(context.getCommand())) {
            context.getModel().lhs = null;
            context.getModel().rhs = null;
            context.getModel().equation = "";
            context.getModel().full = "";
            context.getModel().clearNodes();
            context.setState(new StartState());
        }
    }
}

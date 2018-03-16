package controller.state;

import controller.Controller;

public class FirstOpState implements State {
    @Override
    public void handle(Controller context) {
        if (isDigit(context.getCommand())) {
            context.getModel().equation += context.getCommand().getValue();
            context.getModel().full += context.getCommand().getValue();
        }
        else if (isOp(context.getCommand())) {
            context.getModel().addNode(context.getCommand().getValue(), context.getModel().equation, true); //Left leaf

            context.getModel().currOp = context.getCommand().getValue();

            context.getModel().lhs = Integer.parseInt(context.getModel().equation);
            context.getModel().equation = "";
            context.getModel().full += " " + context.getCommand().getValue() + " ";
            context.setState(new NextOpState());
        }
        else if (isEquals(context.getCommand())) {
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
            context.setState(new StartState());
        }
    }
}
